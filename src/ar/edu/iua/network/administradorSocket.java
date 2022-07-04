/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.iua.network;

import com.google.gson.Gson;
import static ar.edu.iua.network.Util.Sout;
import ar.edu.iua.network.dao.PlanDAO;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import ar.edu.iua.modelo.academico.plan.PlanImpl;

/**
 * @author CARLOMAGNO
 */
public class administradorSocket extends Thread {
	private final Socket conector;
	private String metodoPedido;
	private String httpPedido;

	administradorSocket(Socket insocket) {
		conector = insocket;
	}

	public void procesarSocket() {
		this.start();
	}

	@Override // sobreescribimos el método run del Thread para procesar el socket

	public void run() { // proceso principal del server
		try {
			// capturamos el flujo de entrada
			// creamos un objeto para manipular el pedido. Necesitamos que tenga acceso al
			// socket, y se lo inyectamos en el constructor

			InputStream flujoentrada = conector.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(flujoentrada));

			// necesitamos un printStream para enviar archivos
			PrintStream ps = new PrintStream(new BufferedOutputStream(conector.getOutputStream()));

			// procesamos El Stream y se lo pasamos como String a HttpRequest
			String linea = buffer.readLine();
			String header = linea;
			/** Si la cabecera es nula salimos !!! */
			if (header == null)
				return;

			StringTokenizer tokenizer = new StringTokenizer(header);
			metodoPedido = tokenizer.nextToken();
			httpPedido = tokenizer.nextToken();
			httpPedido = header + "\r\n";

			while (buffer.ready()) {
				/** Leemos todo el pedido HTTP hasta el final.... */
				httpPedido += buffer.readLine() + "\r\n";
			}

			System.out.println("HTTP-METHOD: " + metodoPedido);
			System.out.println(httpPedido);

			HttpRequest req = new HttpRequest(httpPedido);
			HttpResponse resp = new HttpResponse(conector);

			// AHORA PARA VER SI todo ESTA OK VAMOS A GENERAR UN ECHO AL WEB BROWSER
			// ANTES QUE NADA SE ENVIA UN ENCABEZADO DE ESTADO Y AUTORIZACION PARA CORS SINO
			// NO FUNCIONA DESDE OTROS SITIOS EXTERNOS, POR EJEMPLO ALGO QUE HAGAMOS CON
			// ANGULARJS Y
			// QUERRAMOS CONSUMIR EXTERNAMENTE
			// capturamos los parametros enviados

			String PaginaInicio;
			System.out.println("Accion: " + req.getAccion());
			System.out.println(req.getMetodo());

			// EMPEZAMOS EL ANALISIS DE GET
			if (req.getMetodo().trim().equalsIgnoreCase("GET")) {

				if (req.getAccion() != null) {
					String hacer = req.getAccion();

					// ANALIZAMOS LAS ACCIONES
					if (hacer.equalsIgnoreCase("VerPlanes")) {
						Sout("estoy en ReadALL del Get");
						PlanImpl ele = new PlanImpl();
						PlanDAO ldao = new PlanDAO();
						List<PlanImpl> listadoElementos;
						listadoElementos = ldao.readAll();
						PlanImpl elemento = new PlanImpl();
						Gson gson = new Gson();
						String listadoJSON = "[";

						for (int t = 0; t < listadoElementos.size(); t++) {
							elemento = (PlanImpl) listadoElementos.get(t);
							listadoJSON += gson.toJson(elemento) + ",";
						}

						
						
						listadoJSON = listadoJSON.substring(0, listadoJSON.length() - 1);
						listadoJSON += "]";
						// resp.enviarRespuestaDatos(200, resp.getInitPage("Hola Mundo !!!"));
						Sout(gson.toJson((PlanImpl) ele));
						PaginaInicio = resp.getInitPage(gson.toJson((PlanImpl) ele));
						resp.imprimirSalida(resp.getHeader());
						resp.imprimirSalida(listadoJSON);
					} else if (hacer.equalsIgnoreCase("BuscarPlan")) {
						Sout("estoy en Buscar del Get");
						PlanDAO ldao = new PlanDAO();
						List<PlanImpl> listadoElementos = new ArrayList<>();
						String[] parametros = req.getParametros();
						String terminos = "";
						for (String param : parametros) {
							
							if (req.getNombreParametro(param).equals("Terminos")) {
								terminos = URLDecoder.decode(req.getValorParametro(param), StandardCharsets.UTF_8);
							}
						}

						if (!terminos.isBlank()) {
							listadoElementos.addAll(ldao.read(terminos));
						} else {
							listadoElementos = ldao.readAll();
						}
						PlanImpl elemento = new PlanImpl();
						Gson gson = new Gson();
						String listadoJSON = "[";

						for (int t = 0; t < listadoElementos.size(); t++) {
							elemento = (PlanImpl) listadoElementos.get(t);
							listadoJSON += gson.toJson(elemento) + ",";
						}
						listadoJSON = listadoJSON.substring(0, listadoJSON.length() - 1);
						listadoJSON += "]";
						// resp.enviarRespuestaDatos(200, resp.getInitPage("Hola Mundo !!!"));
						resp.imprimirSalida(resp.getHeader());
						resp.imprimirSalida(listadoJSON);

					} else if (hacer.equalsIgnoreCase("BorrarPlan")) {

						Sout("estoy en Borrar del Get");
						PlanDAO ldao = new PlanDAO();
						List<PlanImpl> listadoElementos = new ArrayList<>();

						String[] parametros = req.getParametros();
						String terminos = "";
						Gson gson = new Gson();
						PlanImpl elemento = new PlanImpl();
						for (String param : parametros) {
							switch (req.getNombreParametro(param)) {
								case "Plan":
									String result = URLDecoder.decode(req.getValorParametro(param), StandardCharsets.UTF_8);
									elemento = gson.fromJson(result, PlanImpl.class);
									break;
								case "Terminos":
									terminos = req.getValorParametro(param);
									break;
							}
						}
						ldao.delete(elemento);
						if (!terminos.isBlank()) {
							listadoElementos.addAll(ldao.read(terminos));
						} else {
							listadoElementos = ldao.readAll();
						}
						
						String listadoJSON = "[";

						for (int t = 0; t < listadoElementos.size(); t++) {
							elemento = (PlanImpl) listadoElementos.get(t);
							listadoJSON += gson.toJson(elemento) + ",";
						}
						listadoJSON = listadoJSON.substring(0, listadoJSON.length() - 1);
						listadoJSON += "]";
						// resp.enviarRespuestaDatos(200, resp.getInitPage("Hola Mundo !!!"));
						resp.imprimirSalida(resp.getHeader());
						resp.imprimirSalida(listadoJSON);
					} else if (hacer.equalsIgnoreCase("AgregarPlan")) {

						Sout("estoy en Agregar del Get");
						PlanImpl ele = new PlanImpl();
						PlanImpl elementoAAgregar = new PlanImpl();
						PlanDAO ldao = new PlanDAO();
						List<PlanImpl> listadoElementos = new ArrayList<>();
						Gson gson = new Gson();

						String[] parametros = req.getParametros();
						String terminos = "";
						for (String param : parametros) {
							switch (req.getNombreParametro(param)) {
								case "Plan":
									String result = URLDecoder.decode(req.getValorParametro(param), StandardCharsets.UTF_8);
									elementoAAgregar = gson.fromJson(result, PlanImpl.class);
									break;
								case "Terminos":
									terminos = req.getValorParametro(param);
									break;
							}
						}
						ldao.create(elementoAAgregar);
						if (!terminos.isBlank()) {
							listadoElementos.addAll(ldao.read(terminos));
						} else {
							listadoElementos = ldao.readAll();
						}
						PlanImpl elemento;
						String listadoJSON = "[";

						for (int t = 0; t < listadoElementos.size(); t++) {
							elemento = (PlanImpl) listadoElementos.get(t);

							listadoJSON += gson.toJson(elemento) + ",";
						}
						listadoJSON = listadoJSON.substring(0, listadoJSON.length() - 1);
						listadoJSON += "]";
						// resp.enviarRespuestaDatos(200, resp.getInitPage("Hola Mundo !!!"));
						Sout(gson.toJson((PlanImpl) ele));
						PaginaInicio = resp.getInitPage(gson.toJson((PlanImpl) ele));
						resp.imprimirSalida(resp.getHeader());
						resp.imprimirSalida(listadoJSON);
					} else if (hacer.equalsIgnoreCase("ModificarPlan")) {

						Sout("estoy en Modificar del Get");
						PlanImpl ele = new PlanImpl();
						PlanImpl elementoAModificar = new PlanImpl();
						PlanDAO ldao = new PlanDAO();
						List<PlanImpl> listadoElementos = new ArrayList<>();
						Gson gson = new Gson();

						String[] parametros = req.getParametros();
						String terminos = "";
						for (String param : parametros) {
							switch (req.getNombreParametro(param)) {
								case "Plan":
									String result = URLDecoder.decode(req.getValorParametro(param), StandardCharsets.UTF_8);
									elementoAModificar = gson.fromJson(result, PlanImpl.class);
									break;
								case "Terminos":
									terminos = req.getValorParametro(param);
									break;
							}
						}
						ldao.update(elementoAModificar);
						if (!terminos.isBlank()) {
							listadoElementos.addAll(ldao.read(terminos));
						} else {
							listadoElementos = ldao.readAll();
						}
						PlanImpl elemento;
						String listadoJSON = "[";

						for (int t = 0; t < listadoElementos.size(); t++) {
							elemento = (PlanImpl) listadoElementos.get(t);

							listadoJSON += gson.toJson(elemento) + ",";
						}
						listadoJSON = listadoJSON.substring(0, listadoJSON.length() - 1);
						listadoJSON += "]";
						// resp.enviarRespuestaDatos(200, resp.getInitPage("Hola Mundo !!!"));
						Sout(gson.toJson((PlanImpl) ele));
						PaginaInicio = resp.getInitPage(gson.toJson((PlanImpl) ele));
						resp.imprimirSalida(resp.getHeader());
						resp.imprimirSalida(listadoJSON);
					} else { // no piden ninguna accion enviamos un archivo, por defecto es index.html
						if (req.getAccion().equals("")) // no pidieron nada enviamos pagina principal
						{
							PaginaInicio = resp.getHeader();
							PaginaInicio += resp.getInitPage("Bienvenido a la pagina principal");
							resp.imprimirSalida(PaginaInicio);
						} else { // pidieron un archivo, lo enviamos
							req.enviarArchivo("", ps);
						}
					}
				}
			}

			resp.cerrar();
			conector.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
}

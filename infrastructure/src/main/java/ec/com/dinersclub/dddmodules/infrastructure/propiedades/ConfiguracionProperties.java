package ec.com.dinersclub.dddmodules.infrastructure.propiedades;

import jakarta.inject.Singleton;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Singleton
public class ConfiguracionProperties {

	@ConfigProperty(name = "llaves.criptograficas.canal.url")
	private String rutaLlavesCanal;

	@ConfigProperty(name = "llaves.criptograficas.aplicacion.canal.url")
	private String rutaLlavesAplicacionCanal;

	@ConfigProperty(name = "llaves.simetrica.tamanio")
	private int tamanioLlave;

	public ConfiguracionProperties() {
		super();
	}

	public String getRutaLlavesCanal() {
		return rutaLlavesCanal;
	}

	public String getRutaLlavesAplicacionCanal() {
		return rutaLlavesAplicacionCanal;
	}

	public int getTamanioLlave() {
		return tamanioLlave;
	}

}

package br.com.onsys.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class OnsysSSLSocketFactoryConfiguracao extends SSLSocketFactory {
	private SSLSocketFactory factory;
	private SSLContext sslcontext;

	public OnsysSSLSocketFactoryConfiguracao() {
		try {
			
			
// here you can instanciate your own ssl context with hardened security and your own trust managers which can check the extension
//			SSLContext sslcontext = SSLSecurityInitializer.getContext();
			if (sslcontext == null) {
				sslcontext = SSLContext.getInstance("TLS");
				sslcontext.init(null, // No KeyManager required
						new TrustManager[] { new OnsysTrustManagerConfiguracao() }, 
						new java.security.SecureRandom());
			}
			
			factory = (SSLSocketFactory) sslcontext.getSocketFactory();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static SocketFactory getDefault() {
		return new OnsysSSLSocketFactoryConfiguracao();
	}

	public Socket createSocket(Socket socket, String s, int i, boolean flag) throws IOException {
		return factory.createSocket(socket, s, i, flag);
	}

	public Socket createSocket(InetAddress inaddr, int i, InetAddress inaddr1, int j) throws IOException {
		return factory.createSocket(inaddr, i, inaddr1, j);
	}

	public Socket createSocket(InetAddress inaddr, int i) throws IOException {
		return factory.createSocket(inaddr, i);
	}

	public Socket createSocket(String s, int i, InetAddress inaddr, int j) throws IOException {
		return factory.createSocket(s, i, inaddr, j);
	}

	public Socket createSocket(String s, int i) throws IOException {
		return factory.createSocket(s, i);
	}

	public String[] getDefaultCipherSuites() {
		return factory.getSupportedCipherSuites();
	}

	public String[] getSupportedCipherSuites() {
		return factory.getSupportedCipherSuites();
	}

	public SSLContext getSslcontext() {
		return sslcontext;
	}

	
}

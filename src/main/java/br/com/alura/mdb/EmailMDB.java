package br.com.alura.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.MessageListener;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entities.AgendamentoEmail;
import br.com.alura.exception.BusinessException;
import br.com.alura.interceptor.Logger;

@Logger
@MessageDriven(activationConfig = {
		// destino
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/EmailQueue"),
		// tipo da fila
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class EmailMDB implements MessageListener {

	@Inject
	private AgendamentoEmailBusiness agendamentoEmailBusiness;

	// M?todo responsavel por capturar msg na fila e tratar
	@Override
	public void onMessage(javax.jms.Message message) {

		try {
			AgendamentoEmail agendamentoEmail = message.getBody(AgendamentoEmail.class);
			agendamentoEmailBusiness.enviarEmail(agendamentoEmail);
		} catch (JMSException | BusinessException e) {
			throw new RuntimeException(e);
		}
	}
}
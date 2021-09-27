package br.com.alura.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.dao.AgendamentoEmailDao;
import br.com.alura.entities.AgendamentoEmail;
import br.com.alura.interceptor.Logger;

@Stateless
@Logger
public class AgendamentoEmailBusiness {
	
	@Inject
	private AgendamentoEmailDao agendamentoEmailDao;
	
	public List<AgendamentoEmail> listarAgendamentosEmail(){
		return agendamentoEmailDao.listarAgendamentosEmail();
	}
	
	public void salvarAgendamentosEmail(@Valid AgendamentoEmail agendamentoEmail) {
		
		agendamentoEmail.setEnviado(false);
		agendamentoEmailDao.salvarAgendamentoEmail(agendamentoEmail);
	}

}

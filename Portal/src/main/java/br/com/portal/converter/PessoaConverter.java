package br.com.portal.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.portal.model.Estado;
import br.com.portal.model.Pessoa;
import br.com.portal.repository.Pessoas;

@FacesConverter("pessoaConverter")
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long id = Long.parseLong(valor);
			Pessoa pessoa = new Pessoa();
			Pessoas dao = new Pessoas();
			pessoa = dao.buscarPorCodigo(id);

			return pessoa;
		} catch (RuntimeException e) {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
		try {
			Pessoa pessoa = (Pessoa) object;
			Long id = pessoa.getIdPessoa();

			return id.toString();
		} catch (RuntimeException e) {
			return null;
		}

	}

}

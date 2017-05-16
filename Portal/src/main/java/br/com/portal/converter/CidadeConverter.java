package br.com.portal.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.portal.model.Cidade;
import br.com.portal.model.Estado;
import br.com.portal.repository.Cidades;

@FacesConverter("cidadeConverter")
public class CidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long id = Long.parseLong(valor);
			Cidade cidade = new Cidade();
			Cidades dao = new Cidades();
			cidade = dao.buscarPorCodigo(id);

			return cidade;
		} catch (RuntimeException e) {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
		try {
			Cidade cidade = (Cidade) object;
			Long id = cidade.getIdCidade();

			return id.toString();
		} catch (RuntimeException e) {
			return null;
		}

	}

}

package br.com.portal.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.portal.model.Estado;
import br.com.portal.repository.Estados;

@FacesConverter("estadoConverter")
public class EstadoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long id = Long.parseLong(valor);
			Estado estado = new Estado();
			Estados dao = new Estados();
			estado = dao.buscarPorCodigo(id);

			return estado;
		} catch (RuntimeException e) {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
		try {
			Estado estado = (Estado) object;
			Long id = estado.getIdEstado();

			return id.toString();
		} catch (RuntimeException e) {
			return null;
		}

	}

}

package br.com.casadocodigo.loja.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.casadocodigo.loja.models.Autor;

@FacesConverter("autorConverter")
public class AutorConverter implements Converter{
	
	private Autor autor = new Autor();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		
		if(id == null || id.trim().isEmpty()) return null;

		autor.setId(Integer.valueOf(id));
		
		return autor;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object autorObect) {
		
		if(autorObect == null) return null;
		
		autor = (Autor) autorObect;
		
		return autor.getId().toString();
	}

}

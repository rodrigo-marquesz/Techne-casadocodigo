package br.com.casadocodigo.loja.converters;

import br.com.casadocodigo.loja.models.Autor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("autorConverter")
public class AutorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String id) {
        if (id == null || id.trim().isEmpty())
            return null;

        Autor autor = new Autor();
        autor.setId(Integer.valueOf(id));

        return autor;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object autorObject) {
        if (autorObject == null)
            return null;

        Autor autor = (Autor) autorObject;
        return autor.getId().toString();
    }


}

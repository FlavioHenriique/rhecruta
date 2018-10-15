package br.edu.ifpb.dacrhecruta.convert;

import br.edu.ifpb.dacrhecruta.domain.Vaga;
import com.google.gson.Gson;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Vaga.class, value = "convert.vaga")
public class VagaConvert implements Converter<Vaga> {

    private Gson gson = new Gson();

    @Override
    public Vaga getAsObject(FacesContext fc, UIComponent uic, String string) {
        
        return gson.fromJson(string, Vaga.class);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Vaga t) {
        
        
        return gson.toJson(t);
    }

}

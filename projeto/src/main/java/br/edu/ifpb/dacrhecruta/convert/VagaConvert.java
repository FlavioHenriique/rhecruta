package br.edu.ifpb.dacrhecruta.convert;

import br.edu.ifpb.dacrhecruta.domain.Vaga;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class VagaConvert implements Converter<Vaga>{

    @Override
    public Vaga getAsObject(FacesContext fc, UIComponent uic, String string) {
     
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Vaga t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

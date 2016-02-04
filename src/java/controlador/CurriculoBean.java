/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Curriculo;

/**
 *
 * @author Paulo
 */
@ManagedBean(name = "curriculoBean")
@ViewScoped
public class CurriculoBean {

    private static final String SUCESSO = "Currículo cadastrado com sucesso!";
    private static final String EXCLUSAO = "Currículo excluído com sucesso!";
    private static final String ERRO = "Ops... currículo já cadastrado!";

    private Curriculo curriculo = new Curriculo();
    private List<Curriculo> curriculos = new ArrayList<Curriculo>();

    public void salvar() {
        FacesMessage mensagem;
        if (!curriculos.contains(curriculo)) {
            mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, SUCESSO, null);
            curriculos.add(curriculo);
            curriculo = new Curriculo();
        } else {
            mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, ERRO, null);
        }
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public void excluir(Curriculo curr) {
        curriculos.remove(curr);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, EXCLUSAO, null));        
    }

    public List<Curriculo> getCurriculos() {
        return curriculos;
    }

    public void setCurriculos(List<Curriculo> curriculos) {
        this.curriculos = curriculos;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

}

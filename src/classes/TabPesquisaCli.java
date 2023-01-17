/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;

/**
 *
 * @author EEQS Lab02
 */
public class TabPesquisaCli {
    
    private List <Pessoa> linha; // pesquisa de pessoa
    private List <estoque> linhaEst; // pesquisa de produtos
    private List <Categoria> linhaCat; //pesquisa de produto pela categoria

    private String[] PesquiCpf = new String[]{"CPF","Nome"};
    private String[] PesquiEst = new String[]{"Id","Nome do Produto","Valor","Estoque","ganho"};
    
    /**
     * @return the linha
     */
    public List <Pessoa> getLinha() {
        return linha;
    }

    /**
     * @param linha the linha to set
     */
    public void setLinha(List <Pessoa> linha) {
        this.linha = linha;
    }

    /**
     * @return the linhaEst
     */
    public List <estoque> getLinhaEst() {
        return linhaEst;
    }

    /**
     * @param linhaEst the linhaEst to set
     */
    public void setLinhaEst(List <estoque> linhaEst) {
        this.linhaEst = linhaEst;
    }

    /**
     * @return the linhaCat
     */
    public List <Categoria> getLinhaCat() {
        return linhaCat;
    }

    /**
     * @param linhaCat the linhaCat to set
     */
    public void setLinhaCat(List <Categoria> linhaCat) {
        this.linhaCat = linhaCat;
    }
    
    
//^       ^           ^       ^       ^     encapsular campos
//|       |           |       |       |     Para baixo é o copiado
    
    
    public int getRowCount() {
       return linha.size();
    }


    //@Override
    public int getColumnCountPess() { // obter 
        return PesquiCpf.length;
        //return PesquiEst.length;
    }
    public int getColumnCountEst() { // obter 
        return PesquiEst.length;
    }


    public String[] getColunasPess() { // obter as colunas
        return PesquiCpf;
    }
    
    public String[] getColunasEst() { // obter as colunas
        return PesquiEst;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunasPess(String[] colunas) { // modificar colunas
        this.PesquiCpf = colunas;
    }
    public void setColunasEst (String[] colunas) { // modificar colunas
        this.PesquiEst = colunas;
    }
    
       // @Override
    public Object getValueAtCpf(int linhaIndex, int colunaIndex) { // obter valor
        Pessoa pss = linha.get(linhaIndex);

        
        switch(colunaIndex){
        
            case 0: return pss.getCpf();
            case 1: return pss.getNome();
            
            default: throw  new IndexOutOfBoundsException("Erro ao buscar as colunas pelas clases");
 }}
    
        public Object getValueAtEst(int linhaIndex, int colunaIndex) { // obter valor
        estoque est = linhaEst.get(linhaIndex);

        
        switch(colunaIndex){
        
            case 0: return est.getCodigo();
            case 1: return est.getNOMEP();
            case 2: return est.getPreco();
            case 3: return est.getQtdp();
            case 4: return est.getGanho();
            
            default: throw  new IndexOutOfBoundsException("Erro ao buscar as colunas pelas clases");
 }}
    
        public Class<?> getColumnClassPess (int columnIndex){
    
    switch (columnIndex){
    // se for String ponha String se for int ponha Integer
        
        case 0: return String.class;
        case 1: return String.class;
    
      default: return String.class;
    
    }
   
    }
        public Class<?> getColumnClassEst (int columnIndex){
    
    switch (columnIndex){
    // se for String ponha String se for int ponha Integer
        
        case 0: return Integer.class;
        case 1: return String.class; 
        case 2: return Float.class;
        case 3: return Integer.class;
        case 4: return Float.class;
    
      default: return String.class;
    
    }
    
    }
        
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Cadastros {
     //Atributos da classe
    private String Nome;
    private String CPF;
    private String Idade;
    private String Sexo;
    private String Cidade;
    private String Virus;
    private String Data;
    private String Andamento;
    private String ID;
    private String IDBusca;
    private String DataIni;
    private String DataFim;
    private String IdadeIni;
    private String IdadeFim;
    private String AndamentoPes;
    private String VirusPes;
    private String CidadePes;
    private String SexoPes;
    private int pes;
    private String CPF1;
    private String RetornoRes;
    private String txtReturnoCaso;
    private Date txtDate;
    private Date DateIni;
    private Date DateFim;
    private int CovidMortes;
    private int DengueMortes;
    private int H1Mortes;
    private int CovidCur;
    private int DengueCur;
    private String LocalGraf;

    public String getLocalGraf() {
        return LocalGraf;
    }

    public void setLocalGraf(String LocalGraf) {
        this.LocalGraf = LocalGraf;
    }
    
    

    public int getCovidMortes() {
        return CovidMortes;
    }

    public void setCovidMortes(int CovidMortes) {
        this.CovidMortes = CovidMortes;
    }

    public int getDengueMortes() {
        return DengueMortes;
    }

    public void setDengueMortes(int DengueMortes) {
        this.DengueMortes = DengueMortes;
    }

    public int getH1Mortes() {
        return H1Mortes;
    }

    public void setH1Mortes(int H1Mortes) {
        this.H1Mortes = H1Mortes;
    }

    public int getCovidCur() {
        return CovidCur;
    }

    public void setCovidCur(int CovidCur) {
        this.CovidCur = CovidCur;
    }

    public int getDengueCur() {
        return DengueCur;
    }

    public void setDengueCur(int DengueCur) {
        this.DengueCur = DengueCur;
    }

    public int getH1Cur() {
        return H1Cur;
    }

    public void setH1Cur(int H1Cur) {
        this.H1Cur = H1Cur;
    }
    private int H1Cur;
    
    

    public Date getDateIni() {
        return DateIni;
    }

    public void setDateIni(Date DateIni) {
        this.DateIni = DateIni;
    }

    public Date getDateFim() {
        return DateFim;
    }

    public void setDateFim(Date DateFim) {
        this.DateFim = DateFim;
    }
    
    

    public Date getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(Date txtDate) {
        this.txtDate = txtDate;
    }

    public String getTxtReturnoCaso() {
        return txtReturnoCaso;
    }

    public void setTxtReturnoCaso(String txtReturnoCaso) {
        this.txtReturnoCaso = txtReturnoCaso;
    }

    public String getRetornoRes() {
        return RetornoRes;
    }

    public void setRetornoRes(String RetornoRes) {
        this.RetornoRes = RetornoRes;
    }

    public String getCPF1() {
        return CPF1;
    }

    public void setCPF1(String CPF1) {
        this.CPF1 = CPF1;
    }

    public int getPes() {
        return pes;
    }

    public void setPes(int pes) {
        this.pes = pes;
    }

    public String getDataIni() {
        return DataIni;
    }

    public void setDataIni(String DataIni) {
        this.DataIni = DataIni;
    }

    public String getDataFim() {
        return DataFim;
    }

    public void setDataFim(String DataFim) {
        this.DataFim = DataFim;
    }

    public String getIdadeIni() {
        return IdadeIni;
    }

    public void setIdadeIni(String IdadeIni) {
        this.IdadeIni = IdadeIni;
    }

    public String getIdadeFim() {
        return IdadeFim;
    }

    public void setIdadeFim(String IdadeFim) {
        this.IdadeFim = IdadeFim;
    }

    public String getAndamentoPes() {
        return AndamentoPes;
    }

    public void setAndamentoPes(String AndamentoPes) {
        this.AndamentoPes = AndamentoPes;
    }

    public String getVirusPes() {
        return VirusPes;
    }

    public void setVirusPes(String VirusPes) {
        this.VirusPes = VirusPes;
    }

    public String getCidadePes() {
        return CidadePes;
    }

    public void setCidadePes(String CidadePes) {
        this.CidadePes = CidadePes;
    }

    public String getSexoPes() {
        return SexoPes;
    }

    public void setSexoPes(String SexoPes) {
        this.SexoPes = SexoPes;
    }
    
    public String getIDBusca(){
        return IDBusca;
    }

    //Construtor da classe
    public void setIDBusca(String IDBusca) {
        this.IDBusca = IDBusca;
    }

    public Cadastros() {
    }
    //Metodos get e set

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getIdade() {
        return Idade;
    }

    public void setIdade(String Idade) {
        this.Idade = Idade;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getVirus() {
        return Virus;
    }

    public void setVirus(String Virus) {
        this.Virus = Virus;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getAndamento() {
        return Andamento;
    }

    public void setAndamento(String Andamento) {
        this.Andamento = Andamento;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    void getPes(int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int setpes(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void getCovidMortes(int m1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void getDengueMortes(int m2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

    


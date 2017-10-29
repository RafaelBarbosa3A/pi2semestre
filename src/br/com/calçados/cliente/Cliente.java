package br.com.calçados.cliente;

public class Cliente {

    private int id;
    //dados pessoais
    private String nome;
    private String sobrenome;
    private int rg;
    private long cpf;
    private String sexo;
    private int telefone;
    private String email;
    //dados endereço
    private String endereço;
    private int numero;
    private String complemento;
    private int cep;
    private String bairro;
    private String cidade;
    private String estado;

    //Sets e Gets
    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setRG(int rg) {
        this.rg = rg;
    }

    public int getRG() {
        return this.rg;
    }

    public void setCPF(long cpf) {
        this.cpf = cpf;
    }

    public long getCPF() {
        return this.cpf;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getTelefone() {
        return this.telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getEndereço() {
        return this.endereço;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }
    
    public void setComplemento(String complemento){
        this.complemento = complemento;
    }
    
    public String getComplemento(){
        return this.complemento;
    }
    
    public void setCEP(int cep) {
        this.cep = cep;
    }

    public int getCEP() {
        return this.cep;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return this.bairro;
    }
    
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    
    public String getCidade(){
        return this.cidade;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public String getEstado(){
        return this.estado;
    }
}

package pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="tb_Animal",schema="jogoeducativo")
public class Animal implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="ani_codigo")
    private int codigo;
    
    @Column(name="ani_nome",nullable=false,length=10)
    private String nome;
    
    @Column(name="ani_dicas",nullable=false)   
    private String dicas;
    
    @Column(name="ani_dicaEspecial", nullable=false)
    private String dicaEspecial;
    
    @Column(name="ani_fotoSombra",nullable=false)
    @Lob
    private byte[] fotoComSombra;
	
    
    @Column(name="ani_fotoNormal",nullable=false)
    @Lob
    private byte[] fotoNormal;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDicas() {
        return dicas;
    }

    public void setDicas(String dicas) {
        this.dicas = dicas;
    } 

    public byte[] getFotoComSombra() {
        return fotoComSombra;
    }

    public void setFotoComSombra(byte[] fotoComSombra) {
        this.fotoComSombra = fotoComSombra;
    }

    public byte[] getFotoNormal() {
        return fotoNormal;
    }

    public void setFotoNormal(byte[] fotoNormal) {
        this.fotoNormal = fotoNormal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDicaEspecial() {
        return dicaEspecial;
    }

    public void setDicaEspecial(String dicaEspecial) {
        this.dicaEspecial = dicaEspecial;
    }

    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", nome=" + nome + ", dicas=" + dicas + ", dicaEspecial=" + dicaEspecial 
                + ", fotoComSombra=" + fotoComSombra + ", fotoNormal=" + fotoNormal + '}';
    }   
    
}

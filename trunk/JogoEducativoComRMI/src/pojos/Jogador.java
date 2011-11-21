package pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_jogador",schema="jogoeducativo")
public class Jogador implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="jog_codigo")
    private int codigo;
    
   @Column(name="jog_nome",nullable=false) 
    private String nome;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name="jog_dtSalvo",nullable=false)
   private Date dataSalvo;
   
   @Column(name="jog_pontuacao",nullable=false)
   private int pontuacao;

   @Column(name="jog_qtdeFasesCompletadas",nullable=false)
   private int qtdeFases;

    public int getQtdeFases() {
        return qtdeFases;
    }

    public void setQtdeFases(int qtdeFases) {
        this.qtdeFases = qtdeFases;
    }
   
    public Date getDataSalvo() {
        return dataSalvo;
    }

    public void setDataSalvo(Date dataSalvo) {
        this.dataSalvo = dataSalvo;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String descricao) {
        this.nome = descricao;
    }
    
}

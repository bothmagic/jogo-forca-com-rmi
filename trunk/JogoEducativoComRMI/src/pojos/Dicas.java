package pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_Dicas",schema="jogoeducativo")
public class Dicas implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="dic_codigo")
    private int codigo;
    
   @Column(name="dic_descricao",nullable=false) 
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}

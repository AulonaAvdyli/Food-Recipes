/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "CategoryUnit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoryUnit.findAll", query = "SELECT c FROM CategoryUnit c"),
    @NamedQuery(name = "CategoryUnit.findById", query = "SELECT c FROM CategoryUnit c WHERE c.id = :id")})
public class CategoryUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
     @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer id;
    @JoinColumn(name = "IngredientsCategoryID", referencedColumnName = "ID")
    @ManyToOne
    private IngredientsCategory ingredientsCategoryID;
    @JoinColumn(name = "UnitID", referencedColumnName = "ID")
    @ManyToOne
    private Unit unitID;

    public CategoryUnit() {
    }

    public CategoryUnit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IngredientsCategory getIngredientsCategoryID() {
        return ingredientsCategoryID;
    }

    public void setIngredientsCategoryID(IngredientsCategory ingredientsCategoryID) {
        this.ingredientsCategoryID = ingredientsCategoryID;
    }

    public Unit getUnitID() {
        return unitID;
    }

    public void setUnitID(Unit unitID) {
        this.unitID = unitID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryUnit)) {
            return false;
        }
        CategoryUnit other = (CategoryUnit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.CategoryUnit[ id=" + id + " ]";
    }
    
}

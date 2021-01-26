/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "IngredientsCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngredientsCategory.findAll", query = "SELECT i FROM IngredientsCategory i"),
    @NamedQuery(name = "IngredientsCategory.findById", query = "SELECT i FROM IngredientsCategory i WHERE i.id = :id"),
    @NamedQuery(name = "IngredientsCategory.findByIngredientsCategory", query = "SELECT i FROM IngredientsCategory i WHERE i.ingredientsCategory = :ingredientsCategory")})
public class IngredientsCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
     @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer id;
    @Column(name = "IngredientsCategory")
    private String ingredientsCategory;
    @OneToMany(mappedBy = "ingredientsCategoryID")
    private Collection<CategoryUnit> categoryUnitCollection;

    public IngredientsCategory() {
    }

    public IngredientsCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIngredientsCategory() {
        return ingredientsCategory;
    }

    public void setIngredientsCategory(String ingredientsCategory) {
        this.ingredientsCategory = ingredientsCategory;
    }

    @XmlTransient
    public Collection<CategoryUnit> getCategoryUnitCollection() {
        return categoryUnitCollection;
    }

    public void setCategoryUnitCollection(Collection<CategoryUnit> categoryUnitCollection) {
        this.categoryUnitCollection = categoryUnitCollection;
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
        if (!(object instanceof IngredientsCategory)) {
            return false;
        }
        IngredientsCategory other = (IngredientsCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.IngredientsCategory[ id=" + id + " ]";
    }
    
}

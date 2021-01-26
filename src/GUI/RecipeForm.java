/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.Difficulty;
import BL.PreparationWay;
import BL.Recipe;
import BL.RecipeCategory;
import BL.RecipeType;
import BL.Useri;
import DAL.DifficultyRepository;
import DAL.PreparationWayRepository;
import DAL.RecetaException;
import DAL.RecipeCategoryRepository;
import DAL.RecipeRepository;
import DAL.RecipeTypeRepository;
import GUI.Models.DifficultyComboBox;
import GUI.Models.PreparationWayComboBox;
import GUI.Models.RecipeCategoryComboBox;
import GUI.Models.RecipeTableModel;
import GUI.Models.RecipeTypeComboBox;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author User
 */
public class RecipeForm extends javax.swing.JInternalFrame {

    RecipeCategoryRepository rcr = new RecipeCategoryRepository();
    RecipeTypeRepository rtr = new RecipeTypeRepository();
    DifficultyRepository dr = new DifficultyRepository();
    PreparationWayRepository pwr = new PreparationWayRepository();
    RecipeRepository rr = new RecipeRepository();
    RecipeTableModel rtm = new RecipeTableModel();
    RecipeTableModel itm = new RecipeTableModel();
    RecipeCategoryComboBox rccb = new RecipeCategoryComboBox();
    RecipeTypeComboBox rtcb = new RecipeTypeComboBox();
    DifficultyComboBox dcb = new DifficultyComboBox();
    PreparationWayComboBox pwcb = new PreparationWayComboBox();

    /**
     * Creates new form RecipeForm
     */
    public RecipeForm() {
        initComponents();
        loadComboBox();
        loadTable();
        tabelaSelectedIndexChange();
    }

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = ingredientTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Recipe i = rtm.getRecipe(selectedIndex);
                    //EntityName en = entm.getEntityName(selectedIndex);
                    titleTxt.setText(i.getTitle());
                    recipeNoTxt.setText(i.getRecipeNumber() + " ");
                    jDateChooser1.getDate();
                    i.setRecipeTypeID((RecipeType) rtcb.getSelectedItem());
                    i.setRecipeCategoryID((RecipeCategory)rccb.getSelectedItem());
                    i.setPreparationWayID((PreparationWay) pwcb.getSelectedItem());
                    
                    

                    //component2.setText(en.getParam());
                }
            }
        });
    }

    public void loadComboBox() {
        try {
            List<RecipeCategory> lista = rcr.findAll();
            List<RecipeType> lista1 = rtr.findAll();
            List<Difficulty> lista2 = dr.findAll();
            List<PreparationWay> lista3 = pwr.findAll();
            rccb.add(lista);
            categoryCMB.setModel(rccb);
            categoryCMB.repaint();
            rtcb.add(lista1);
            recipeTypeCMB.setModel(rtcb);
            recipeTypeCMB.repaint();
            pwcb.add(lista3);
            prepWayCMB.setModel(pwcb);
            prepWayCMB.repaint();
            dcb.add(lista2);
            difficultyCMB.setModel(dcb);
            difficultyCMB.repaint();

        } catch (RecetaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void loadTable() {
        try {
            List<Recipe> list = rr.findAll();
            rtm.addList(list);
            ingredientTable.setModel(rtm);
            rtm.fireTableDataChanged();
        } catch (RecetaException ex) {
            Logger.getLogger(RecipeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clear() {
        ingredientTable.clearSelection();
        titleTxt.setText("");
        recipeNoTxt.setText(" ");
        jDateChooser1.getDate().equals(" ");
        cookingTimeTxt.setText(" ");
        caloriesTxt.setText(" ");
        authorTxt.setText(" ");
        cityTxt.setText(" ");
        commentTxt.setText(" ");
        descriptionTxt.setText(" ");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLbL = new javax.swing.JLabel();
        titleTxt = new javax.swing.JTextField();
        recipeNoLbl = new javax.swing.JLabel();
        recipeNoTxt = new javax.swing.JTextField();
        creationDateLbl = new javax.swing.JLabel();
        categoryLbl = new javax.swing.JLabel();
        categoryCMB = new javax.swing.JComboBox();
        recipeTypeLbl = new javax.swing.JLabel();
        recipeTypeCMB = new javax.swing.JComboBox();
        prepWayLbl = new javax.swing.JLabel();
        prepWayCMB = new javax.swing.JComboBox();
        difficultyLbl = new javax.swing.JLabel();
        difficultyCMB = new javax.swing.JComboBox();
        cookingTimeTxt = new javax.swing.JTextField();
        cookingTimeLbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        caloriesTxt = new javax.swing.JTextField();
        caloriesLbl = new javax.swing.JLabel();
        authorTxt = new javax.swing.JTextField();
        authorLbl = new javax.swing.JLabel();
        cityTxt = new javax.swing.JTextField();
        cityLbl = new javax.swing.JLabel();
        commentLbl = new javax.swing.JLabel();
        commentTxt = new javax.swing.JTextField();
        descriptionLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTxt = new javax.swing.JTextArea();
        IngredientLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ingredientTable = new javax.swing.JTable();
        saveBtn = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        deleteBtn = new javax.swing.JButton();

        titleLbL.setText("Title:");

        recipeNoLbl.setText("Recipe No. :");

        creationDateLbl.setText("Creation date: ");

        categoryLbl.setText("Category:");

        recipeTypeLbl.setText("Recipe Type:");

        prepWayLbl.setText("Prep. Way:");

        difficultyLbl.setText("Difficulty:");

        cookingTimeLbl.setText("Cooking time:");

        jLabel9.setText("min");

        caloriesLbl.setText("Calories:");

        authorLbl.setText("Author:");

        cityLbl.setText("City:");

        commentLbl.setText("Comment:");

        commentTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentTxtActionPerformed(evt);
            }
        });

        descriptionLbl.setText("Description:");

        descriptionTxt.setColumns(20);
        descriptionTxt.setRows(5);
        jScrollPane1.setViewportView(descriptionTxt);

        IngredientLbl.setText("Ingredients");

        ingredientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(ingredientTable);

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prepWayLbl)
                                    .addComponent(recipeTypeLbl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prepWayCMB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(recipeTypeCMB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(recipeNoLbl)
                                            .addComponent(titleLbL))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(recipeNoTxt)
                                            .addComponent(titleTxt)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(creationDateLbl)
                                            .addComponent(categoryLbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(categoryCMB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(difficultyLbl)
                                .addGap(35, 35, 35)
                                .addComponent(difficultyCMB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cookingTimeLbl)
                                    .addComponent(caloriesLbl)
                                    .addComponent(commentLbl)
                                    .addComponent(authorLbl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(authorTxt)
                                    .addComponent(caloriesTxt)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cookingTimeTxt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cityLbl)
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cityTxt)
                                    .addComponent(commentTxt))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(descriptionLbl)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(IngredientLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(deleteBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleLbL)
                            .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(recipeNoLbl)
                                    .addComponent(recipeNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(creationDateLbl)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(categoryCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(categoryLbl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(recipeTypeCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(recipeTypeLbl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(prepWayLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(prepWayCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(9, 9, 9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(difficultyCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(difficultyLbl))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(cookingTimeLbl)
                                                .addComponent(cookingTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(caloriesLbl)
                                            .addComponent(caloriesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(authorLbl)
                                            .addComponent(authorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cityLbl)
                                            .addComponent(cityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(commentLbl)
                                            .addComponent(commentTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(21, 21, 21))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(IngredientLbl)
                                .addGap(291, 291, 291))))
                    .addComponent(descriptionLbl)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void commentTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentTxtActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        int row = ingredientTable.getSelectedRow();
        if (row == -1) {
            Recipe r = new Recipe();
            
            r.setTitle(titleTxt.getText());
            r.setRecipeNumber(Integer.parseInt(recipeNoTxt.getText()));
            r.setCreationDate(jDateChooser1.getDate());
            

            r.setRecipeTypeID((RecipeType) rtcb.getSelectedItem());
            r.setRecipeCategoryID((RecipeCategory)rccb.getSelectedItem());
            r.setPreparationWayID((PreparationWay) pwcb.getSelectedItem());
            r.setDifficultyID((Difficulty) dcb.getSelectedItem());
            r.setCookingTime(Integer.parseInt(cookingTimeTxt.getText()));
            r.setCalories(Integer.parseInt(caloriesTxt.getText()));
            r.setCity(cityTxt.getText());
            
            r.setAuthorComment(commentTxt.getText());
            r.setRecipeDescription(descriptionTxt.getText());
            try {
                rr.create(r);
                clear();
                loadTable();
            } catch (RecetaException ex) {
                JOptionPane.showMessageDialog(null, "Gabim diqka!");
            }
        } else {
            Recipe r = rtm.getRecipe(row);
            r.setRecipeDescription(descriptionTxt.getText());
            try {
                rr.edit(r);
                clear();
                loadTable();
            } catch  (RecetaException ex) {
                JOptionPane.showMessageDialog(null, "Gabim diqka!");
            }

        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = ingredientTable.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                try {
                    Recipe r = rtm.getRecipe(row);
                    rr.delete(r);
                    clear();
                    loadTable();
                } catch (RecetaException ex) {
                    JOptionPane.showMessageDialog(null, "Gabim diqka!");
                }
            } else {
                clear();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgje per te fshire!");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IngredientLbl;
    private javax.swing.JLabel authorLbl;
    private javax.swing.JTextField authorTxt;
    private javax.swing.JLabel caloriesLbl;
    private javax.swing.JTextField caloriesTxt;
    private javax.swing.JComboBox categoryCMB;
    private javax.swing.JLabel categoryLbl;
    private javax.swing.JLabel cityLbl;
    private javax.swing.JTextField cityTxt;
    private javax.swing.JLabel commentLbl;
    private javax.swing.JTextField commentTxt;
    private javax.swing.JLabel cookingTimeLbl;
    private javax.swing.JTextField cookingTimeTxt;
    private javax.swing.JLabel creationDateLbl;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JTextArea descriptionTxt;
    private javax.swing.JComboBox difficultyCMB;
    private javax.swing.JLabel difficultyLbl;
    private javax.swing.JTable ingredientTable;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox prepWayCMB;
    private javax.swing.JLabel prepWayLbl;
    private javax.swing.JLabel recipeNoLbl;
    private javax.swing.JTextField recipeNoTxt;
    private javax.swing.JComboBox recipeTypeCMB;
    private javax.swing.JLabel recipeTypeLbl;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel titleLbL;
    private javax.swing.JTextField titleTxt;
    // End of variables declaration//GEN-END:variables
}
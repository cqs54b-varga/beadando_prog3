package kezdooldal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;



public class QuizFrm extends javax.swing.JFrame {
        String[] questions = new String[20];
        String[][] answers = new String[20][4];
        int index = 0, right = 0, wrong = 0, check = 0, qnum = 1;
   
    public QuizFrm() {
        initComponents();
        teszt.setText(qnum+". kérdés");
                try{
        BufferedReader reader = new BufferedReader(new FileReader("kerdesek.txt"));
        while(index<20)
        {
            questions[index] = reader.readLine();
            index++;
        }
        reader.close();
        index = 0;
        }
        catch(IOException e){
        e.printStackTrace();
        }
        try{
        BufferedReader answerReader = new BufferedReader(new FileReader("valaszok.txt"));
        for (int i = 0; i < 20; i++) {
                String[] v = answerReader.readLine().split(",");
                for (int j = 0; j < 4; j++){
                    answers[i][j] = v[j];
                }
            }
        
            
            index++;
        }
        catch(IOException e){
        e.printStackTrace();
    }
        index = 0;
        right = 0;
        wrong = 0;
        questionLbl.setText(questions[index]);
        answerBttn1.setText(answers[index][0]);
        answerBttn2.setText(answers[index][1]);
        answerBttn3.setText(answers[index][2]);
        answerBttn4.setText(answers[index][3]);
        if(index == 0){
        pontszam.setText(right+" pont");
        teszt.setText(qnum+". kérdés");
        }
        else{
            pontszam.setText("0 pont");
        }

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        QuestionPnl = new javax.swing.JPanel();
        teszt = new javax.swing.JLabel();
        questionLbl = new javax.swing.JTextField();
        pontszam = new javax.swing.JLabel();
        answerBttn1 = new javax.swing.JButton();
        answerBttn2 = new javax.swing.JButton();
        answerBttn3 = new javax.swing.JButton();
        answerBttn4 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setMaximumSize(new java.awt.Dimension(600, 450));
        jPanel2.setMinimumSize(new java.awt.Dimension(600, 450));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 450));

        QuestionPnl.setBackground(new java.awt.Color(0, 0, 0));

        teszt.setForeground(new java.awt.Color(255, 255, 255));
        teszt.setText("Számláló");

        questionLbl.setEditable(false);
        questionLbl.setBackground(new java.awt.Color(0, 0, 0));
        questionLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        questionLbl.setForeground(new java.awt.Color(255, 255, 255));
        questionLbl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        questionLbl.setText("Kérdések");

        pontszam.setBackground(new java.awt.Color(0, 0, 0));
        pontszam.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        pontszam.setForeground(new java.awt.Color(255, 255, 255));
        pontszam.setText("0 pont");
        pontszam.setMaximumSize(new java.awt.Dimension(85, 15));
        pontszam.setMinimumSize(new java.awt.Dimension(85, 15));
        pontszam.setPreferredSize(new java.awt.Dimension(85, 15));

        javax.swing.GroupLayout QuestionPnlLayout = new javax.swing.GroupLayout(QuestionPnl);
        QuestionPnl.setLayout(QuestionPnlLayout);
        QuestionPnlLayout.setHorizontalGroup(
            QuestionPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuestionPnlLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(QuestionPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(QuestionPnlLayout.createSequentialGroup()
                        .addComponent(teszt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pontszam, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(questionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        QuestionPnlLayout.setVerticalGroup(
            QuestionPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuestionPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QuestionPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teszt)
                    .addComponent(pontszam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(questionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        answerBttn1.setBackground(new java.awt.Color(255, 0, 51));
        answerBttn1.setForeground(new java.awt.Color(242, 242, 242));
        answerBttn1.setText("Válasz1");
        answerBttn1.setActionCommand("answerBttn");
        answerBttn1.setMaximumSize(new java.awt.Dimension(220, 40));
        answerBttn1.setMinimumSize(new java.awt.Dimension(220, 40));
        answerBttn1.setPreferredSize(new java.awt.Dimension(220, 40));
        answerBttn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerBttn1ActionPerformed(evt);
            }
        });

        answerBttn2.setBackground(new java.awt.Color(0, 0, 255));
        answerBttn2.setForeground(new java.awt.Color(255, 255, 255));
        answerBttn2.setText("Válasz2");
        answerBttn2.setActionCommand("answerBttn");
        answerBttn2.setMaximumSize(new java.awt.Dimension(220, 40));
        answerBttn2.setMinimumSize(new java.awt.Dimension(220, 40));
        answerBttn2.setPreferredSize(new java.awt.Dimension(220, 40));
        answerBttn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerBttn2ActionPerformed(evt);
            }
        });

        answerBttn3.setBackground(new java.awt.Color(255, 255, 0));
        answerBttn3.setText("Válasz3");
        answerBttn3.setActionCommand("answerBttn");
        answerBttn3.setMaximumSize(new java.awt.Dimension(220, 40));
        answerBttn3.setMinimumSize(new java.awt.Dimension(220, 40));
        answerBttn3.setPreferredSize(new java.awt.Dimension(220, 40));
        answerBttn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerBttn3ActionPerformed(evt);
            }
        });

        answerBttn4.setText("Válasz4");
        answerBttn4.setActionCommand("answerBttn");
        answerBttn4.setMaximumSize(new java.awt.Dimension(220, 40));
        answerBttn4.setMinimumSize(new java.awt.Dimension(220, 40));
        answerBttn4.setPreferredSize(new java.awt.Dimension(220, 40));
        answerBttn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerBttn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(answerBttn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answerBttn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answerBttn4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerBttn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(QuestionPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(QuestionPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerBttn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerBttn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerBttn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerBttn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void answerBttn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerBttn1ActionPerformed
        qnum++;
        if (index==19) {
        wrong++;
        Object[] options = {"Igen", "Nem"};
        int result = JOptionPane.showOptionDialog(null,"\nHelyes válaszok száma:"+right+"\nHelytelen válaszok száma:"+wrong+"\nSzeretnéd újrakezdeni?","A játéknak vége!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,
            options,
            options[0]
            );
            if (result == 0 ) {
                index = 0;
                right = 0;
                wrong = 0;
                qnum = 1;
                questionLbl.setText(questions[index]);
                answerBttn1.setText(answers[index][0]);
                answerBttn2.setText(answers[index][1]);
                answerBttn3.setText(answers[index][2]);
                answerBttn4.setText(answers[index][3]);
                teszt.setText(qnum+". kérdés");
                pontszam.setText("0 pont");
            }
            else{
                 dispose();
               openfokez();
                index = 0;
                right = 0;
                wrong = 0;
                qnum = 1;
            }
        }
        else{
            teszt.setText(qnum+". kérdés");
            index++;
            pontszam.setText(right+" pont");
            questionLbl.setText(questions[index]);
            answerBttn1.setText(answers[index][0]);
            answerBttn2.setText(answers[index][1]);
            answerBttn3.setText(answers[index][2]);
            answerBttn4.setText(answers[index][3]);
        if (index == 0){
        check = 0;
        }
        else{
        check = index -1;
        }
        switch (check){
            case 1 -> right++;
            case 3 -> right++;
            case 5 -> right++;
            case 8 -> right++;
            case 12 -> right++;
            default -> wrong++;
        }
        pontszam.setText(right+" pont");
        }

    }//GEN-LAST:event_answerBttn1ActionPerformed
private void openfokez() {
     fokez f = new fokez();
     f.setVisible(true);
}
    private void answerBttn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerBttn2ActionPerformed
        qnum++;
        if (index==19) {
        wrong++;
        Object[] options = {"Igen", "Nem"};
        int result = JOptionPane.showOptionDialog(null,"\nHelyes válaszok száma:"+right+"\nHelytelen válaszok száma:"+wrong+"\nSzeretnéd újrakezdeni?", "A játéknak vége!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
        null,
            options,
            options[0]
            );
            if (result == 0 ) {
                index = 0;
                right = 0;
                wrong = 0;
                qnum = 1;
                questionLbl.setText(questions[index]);
                answerBttn1.setText(answers[index][0]);
                answerBttn2.setText(answers[index][1]);
                answerBttn3.setText(answers[index][2]);
                answerBttn4.setText(answers[index][3]);
                teszt.setText(qnum+". kérdés");
                pontszam.setText("0 pont");
            }
            else{
                 dispose();
               openfokez();
                index = 0;
                right = 0;
                wrong = 0;
                qnum = 1;
            }
        }
        else{
        teszt.setText(qnum+". kérdés");
        index++;
        teszt.setText(qnum+". kérdés");
        if (index == 0){
        check = 0;
        }
        else{
        check = index -1;
        }
        if(index < 21){
        questionLbl.setText(questions[index]);
        answerBttn1.setText(answers[index][0]);
        answerBttn2.setText(answers[index][1]);
        answerBttn3.setText(answers[index][2]);
        answerBttn4.setText(answers[index][3]);
        }
        else{
        questionLbl.setText(questions[20]);
        answerBttn1.setText(answers[20][0]);
        answerBttn2.setText(answers[20][1]);
        answerBttn3.setText(answers[20][2]);
        answerBttn4.setText(answers[20][3]);
        }
        check = index -1;
        switch (check) {
            case 2 -> right++;
            case 4 -> right++;
            case 7 -> right++;
            case 15 -> right++;
            case 18 -> right++;
            default -> wrong++;
        }
        pontszam.setText(right+" pont");
        }


    }//GEN-LAST:event_answerBttn2ActionPerformed

    private void answerBttn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerBttn3ActionPerformed
        qnum++;
        if (index==19) {
        right++;
        Object[] options = {"Igen", "Nem"};
        int result = JOptionPane.showOptionDialog(null,"\nHelyes válaszok száma:"+right+"\nHelytelen válaszok száma:"+wrong+"\nSzeretnéd újrakezdeni?", "A játéknak vége!",
   JOptionPane.YES_NO_OPTION,
   JOptionPane.QUESTION_MESSAGE,
        null,
            options,
            options[0]
            );
            if (result == 0 ) {
                index = 0;
                right = 0;
                wrong = 0;
                qnum = 1;
                questionLbl.setText(questions[index]);
                answerBttn1.setText(answers[index][0]);
                answerBttn2.setText(answers[index][1]);
                answerBttn3.setText(answers[index][2]);
                answerBttn4.setText(answers[index][3]);
                teszt.setText(qnum+". kérdés");
                pontszam.setText("0 pont");
            }
            else{
                 dispose();
                openfokez();
                index = 0;
                right = 0;
                wrong = 0;
                qnum = 1;
            }
            
        }
        
        else{
        teszt.setText(qnum+". kérdés");
        index++;
        teszt.setText(qnum+". kérdés");
        pontszam.setText(right+" pont");
        questionLbl.setText(questions[index]);
        answerBttn1.setText(answers[index][0]);
        answerBttn2.setText(answers[index][1]);
        answerBttn3.setText(answers[index][2]);
        answerBttn4.setText(answers[index][3]);
        if (index == 0){
        check = 0;
        }
        else{
        check = index -1;
        }
        switch (check) {
            case 6 -> right++;
            case 9 -> right++;
            case 11 -> right++;
            case 13 -> right++;
            case 19 -> right++;
            default -> wrong++;
        }
        }
        pontszam.setText(right+" pont");
    }//GEN-LAST:event_answerBttn3ActionPerformed

    private void answerBttn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerBttn4ActionPerformed
        qnum++;
        if (index==19){
        wrong ++;
        Object[] options = {"Igen", "Nem"};
        int result = JOptionPane.showOptionDialog(null,"\nHelyes válaszok száma:"+right+"\nHelytelen válaszok száma:"+wrong+"\nSzeretnéd újrakezdeni?", "A játéknak vége!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
        null,
            options,
            options[0]
            );
            if (result == 0 ) {
                index = 0;
                right = 0;
                wrong = 0;
                qnum = 1;
                questionLbl.setText(questions[index]);
                answerBttn1.setText(answers[index][0]);
                answerBttn2.setText(answers[index][1]);
                answerBttn3.setText(answers[index][2]);
                answerBttn4.setText(answers[index][3]);
                teszt.setText(qnum+". kérdés");
                pontszam.setText("0 pont");
            }

            else{
                dispose();
                openfokez();
                index = 0;
                right = 0;
                wrong = 0;
            }
        }
        else{
            
            teszt.setText(qnum+". kérdés");

        index++;
        questionLbl.setText(questions[index]);
        answerBttn1.setText(answers[index][0]);
        answerBttn2.setText(answers[index][1]);
        answerBttn3.setText(answers[index][2]);
        answerBttn4.setText(answers[index][3]);
        if (index == 0){
        check = 0;
        }
        else{
        check = index -1;
        }
        switch (check) {
            case 0 -> right++;
            case 10 -> right++;
            case 14 -> right++;
            case 16 -> right++;
            case 17 -> right++;
            default -> wrong++;
        }
        }

        pontszam.setText(right+" pont");
    }//GEN-LAST:event_answerBttn4ActionPerformed


    public static void main(String args[]) {
        
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizFrm().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QuestionPnl;
    private javax.swing.JButton answerBttn1;
    private javax.swing.JButton answerBttn2;
    private javax.swing.JButton answerBttn3;
    private javax.swing.JButton answerBttn4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel pontszam;
    private javax.swing.JTextField questionLbl;
    private javax.swing.JLabel teszt;
    // End of variables declaration//GEN-END:variables
}

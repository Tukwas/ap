
package quizapplication;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;


public class Loading extends javax.swing.JFrame {

    
    public Loading() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        keeptoo.KGradientPanel kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        loadinglabel = new javax.swing.JLabel();
        progressbar = new javax.swing.JProgressBar();
        loadingVal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setBackground(new java.awt.Color(0, 153, 153));
        kGradientPanel1.setkEndColor(new java.awt.Color(206, 92, 165));
        kGradientPanel1.setkStartColor(new java.awt.Color(240, 122, 46));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizapplication/output-onlinegiftools (1).gif"))); // NOI18N

        loadinglabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        loadinglabel.setForeground(new java.awt.Color(255, 255, 255));
        loadinglabel.setText("Loading...");

        loadingVal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        loadingVal.setForeground(new java.awt.Color(255, 255, 255));
        loadingVal.setText("0%");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(261, 261, 261))
            .addComponent(progressbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loadinglabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadingVal)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadinglabel)
                    .addComponent(loadingVal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
  public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Loading lo = new Loading();
                lo.pack();
                lo.setLocationRelativeTo(null);
                lo.setVisible(true);

                new SwingWorker<Void, Integer>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        try {
                            for (int i = 0; i <= 100; i++) {
                                Thread.sleep(100);
                                publish(i);

                                if (i == 10) {
                                    lo.loadinglabel.setText("Turning Modules...");
                                }
                                if (i == 20) {
                                    lo.loadinglabel.setText("Loading Modules...");
                                }
                                if (i == 50) {
                                    lo.loadinglabel.setText("Connecting to Database...");
                                }
                                if (i == 70) {
                                    lo.loadinglabel.setText("Connection Successfully...");
                                }
                                if (i == 80) {
                                    lo.loadinglabel.setText("Launching Application...");
                                }
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                        return null;
                    }

                    @Override
                    protected void process(java.util.List<Integer> chunks) {
                        int value = chunks.get(chunks.size() - 1);
                        lo.loadingVal.setText(value + "%");
                        lo.progressbar.setValue(value);
                    }

                    @Override
                    protected void done() {
                        lo.dispose(); // Close the loading screen
                        log l = new log(); // Show the login screen
                        l.pack();
                        l.setLocationRelativeTo(null);// set to center
                        l.setVisible(true);
                        
                    }
                }.execute();
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel loadingVal;
    private javax.swing.JLabel loadinglabel;
    private javax.swing.JProgressBar progressbar;
    // End of variables declaration//GEN-END:variables
}

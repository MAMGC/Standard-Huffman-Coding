/*Name : Mohamed Ashour Mahmoud
ID : 20170240
G3
 */
import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Huffman extends javax.swing.JFrame {

    public Huffman() {
//        this.probabilities = new ArrayList<char , Integer>();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("celect your choice :");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 153));
        jButton1.setText("compress");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 0, 153));
        jButton2.setText("decompress");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addComponent(jLabel2)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Scanner sc;

    public void open_file(String FileName) {
        try {
            sc = new Scanner(new File(FileName));
        } catch (Exception e) {
            jLabel2.setText("Can not find File ");
        }
    }

    public void close_file() {
        sc.close();
    }

    Formatter out; //34an yktb el tag be format el string

    public void openfile(String pass) {
        try {
            out = new Formatter(pass);
        } catch (Exception e) {
            jLabel2.setText("Can not find File ");
        }

    }

    public void closefile() {
        out.close();
    }

    public void write_code(String code) {

        out.format("%s", code);
        out.format("%n");
        out.flush(); // 34an yktb 3al file

    }

    public class element
    {
        private String letter , code ;
        private int freq ;
        private int left = -1 , right = -1 ;
        
        public element() {}

        public element(String l, int p)
        {
            
            letter = l;
            freq = p;

        }

        public void set_letter(String c) 
        {
            letter = c;
        }
      
        public void set_freq(int p) 
        {
            freq = p;
        }
        
        public void set_code (String c)
        {
            code = c ;
        }
        
        public String get_code ()
        {
            return code ;
        }
        
        public String get_letter() 
        {
            return letter;
        }
        
        public int get_freq() 
        {
            return freq;
        }
        
        public void set_left (int l)
        {
            left=l;
        }
        
        public void set_right (int r)
        {
            right=r;
        }
        
        public int get_left ()
        {
            return left ;
        }
        
        public int get_rigth ()
        {
            return right ;
        }
   
    }

    ArrayList < element > elements  = new ArrayList <element>(); // da kda feeh kol el 7rof bel freq bt3hom 
    ArrayList < ArrayList <element> > refrence_array  = new ArrayList < ArrayList <element>>(); // da kda by4awer 3ala el arrays l gdeda b3d ma bngm3 a5r 2 freq
    
    
    public void sort_freq ( ArrayList<element> array) 
    {
        for (int i = 0; i < array.size(); i++) 
        {
            for (int j = i + 1; j < array.size(); j++) 
            {
                if (array.get(i).get_freq() < array.get(j).get_freq())
                {
                    Collections.swap(array , i , j);
                }
            }
        }

    }

    public void calculate_freq (String data)
    {
        for (int i = 0; i < data.length(); i++)  // loop 3ala l klma kolha 7rf 7rf
        {
            String letter = "" ;
            letter += data.charAt(i); 
           
            boolean found = false;

            for (int j = 0; j < elements.size(); j++) // loop 3ala l array of elements 
            {
                if (elements.get(j).get_letter().equals(letter)) // law l 7arf da mwgod 2abl kda 
                {
                    int new_freq = elements.get(j).get_freq()+1 ; // bnzwd el freq bta3o be wa7d 
                    elements.get(j).set_freq(new_freq); 
                    found = true; // 34an maykml4 fe b2eet el array of elements 
                    break;
                }
            }

            if (found == false) // law el 7arf da awl mara yegi ha3mlo add wel freq =1 
            {
                elements.add( new element (letter , 1)) ; 
            }

        }

        sort_freq(elements);

    }
    
    public void collect_two_freq ( ArrayList <element> original )
    {
        
        for (int k =0 ; k<elements.size()-1 ; k++) // num of arrays eli han3mlha "iterations"
        {   
            refrence_array.add(original); // bndef el prev elements 
            ArrayList <element> new_arr = new ArrayList <element>(); // da eli hagm3 feeh a5r 2 prob we a3ml copy lel elements el adema ... cur elements
            
            for (int i=0 ; i< original.size()-2 ; i++) // copying all elements except the last 2 freq
            {
                element temp = new element ();
                temp.set_freq(original.get(i).get_freq());
                temp.set_letter(original.get(i).get_letter());
                new_arr.add(temp);
            }
            
            int left_indx = original.size()-2 ;  
            int right_indx = original.size()-1 ;
            
            
            element sum = new element();   // sum of the last two elements  
            sum.set_freq( original.get(original.size()-2).get_freq() + original.get(original.size()-1).get_freq() );
            sum.set_letter(original.get(original.size()-2).get_letter()+ original.get(original.size()-1).get_letter());
            sum.set_left(left_indx);
            sum.set_right(right_indx);
            
            
            new_arr.add(sum);
            
            sort_freq(new_arr); // sort b3d ma 3mlna add lel sum according lel freq
            
            original = new_arr ; // bn5ly el prev ysawey el cur eli na w2fa 3leh nw
            
        }
        
        
    }
    
    public void assign_codes ()
    {
        refrence_array.get(refrence_array.size()-1).get(0).set_code("0"); // assign zero to first element in the last array ( eli feh 2 prob bs )
        refrence_array.get(refrence_array.size()-1).get(1).set_code("1"); // assign one to the other element 
        
        for (int cur=refrence_array.size()-1 ; cur>0 ; cur--) // loop btm4y 3ala l ref array mn el a5er
        {   
           for (int i=0 ; i<refrence_array.get(cur).size() ; i++) // loop 3ala l cur array
           {  
               int prev = cur-1 ; // indx of prev (bnsba lel cur) array according lel ref arr
               
               // data of the current cell of the curr array
               String parent_code = refrence_array.get(cur).get(i).get_code();
               String Parent_letter = refrence_array.get(cur).get(i).get_letter();
               int left_child = refrence_array.get(cur).get(i).get_left() ;
               int right_child = refrence_array.get(cur).get(i).get_rigth() ;
               
               
              if ( ( left_child != -1 ) && (right_child != -1) ) // m3naha eno el cell dy parent le 2 childs mn el prev array "gaya mnhom"
              {   
                  String left_code = parent_code+"0"; 
                  String right_code = parent_code+"1";
                  
                  refrence_array.get(prev).get(left_child).set_code(left_code);
                  refrence_array.get(prev).get(right_child).set_code(right_code);
                  
              } 
              
              else  // law maknt4 el klma dy gaya mn childs hanro7 ndwr 3leha fel prev array 34an n7otlha nfs l code b3tha nw
              {
                    for (int k = 0; k < refrence_array.get(prev).size(); k++) // b3ml loop 3ala l prev array 34an adwr 3ala l klma
                    {
                        if (refrence_array.get(prev).get(k).get_letter() == Parent_letter) 
                        {   
                            refrence_array.get(prev).get(k).set_code(parent_code);
                            break ; // just saving time 34an maykml4 fel loop 
                        }
                    }

               }

            }
        }
        
    }
    
  
    public void compress(String data) {

        calculate_freq (data);
        
        collect_two_freq(elements); // bygm3 l array le 2 prob 
        
        assign_codes (); // byrg3 le wara we y3ml l code
        
        openfile("Compressed Data.txt");
        
        String compressed_data = "";
        
        for (int i=0 ; i<data.length() ; i++)
        {
            String cur_letter = "";
            cur_letter += data.charAt(i);
            
            for (int j=0 ; j<refrence_array.get(0).size() ; j++) // b4of el 7arf da anhy wa7d fel array 3ndy we aktb el code l mokabel leeh 
            {
                 if (cur_letter.equals(refrence_array.get(0).get(j).get_letter()))
                 {   
                     compressed_data+=refrence_array.get(0).get(j).get_code();
                     break ;
                 }
            }
           
        }
        
        write_code(compressed_data);

        closefile();
        
        save_table();
    
    }

    public void save_table ()
    {
        openfile("Table.txt");
       
        for (int j = 0; j < refrence_array.get(0).size(); j++) 
        {   
            String element = refrence_array.get(0).get(j).get_letter() +  refrence_array.get(0).get(j).get_code();
            out.format("%s",element);
            out.format("%n");
            out.flush(); // 34an yktb 3al file
        }
        
       closefile();
       
    }
    
    public void read_file(String FileName) { // read data file

        open_file(FileName);
        String data = "";

        while (sc.hasNext()) // while it's not the end of file 
        {
            data += sc.nextLine(); // read line then append " ignore white spaces "

        }

        compress(data);
        close_file();

    }

    String res = "";

    public void reconstruct_table(ArrayList <element> table)
    {
       
        open_file("Table.txt");
       
        String element = "";

        while (sc.hasNext()) // while it's not the end of file 
        {
            element = sc.nextLine(); 
            String letter = element.substring(0 , 1); // el 7arf bykon awl 7aga fel line 
            element = element.substring(1); // b3ml cut le b2et el klma
            String code = element ; // el code haykon b2el el line
            element cur = new element ();
            cur.set_code(code);
            cur.set_letter(letter);
            table.add(cur); // b3ml add lel element fel table
        }
        
        close_file();
        
    }
    
    public void decrypt() 
    {
        ArrayList<element> table = new ArrayList<element>();
        reconstruct_table(table);

        open_file("Compressed Data.txt");
        
         String comp_stream = "" ;
        
        while (sc.hasNext()) // while it's not the end of file 
        {
            comp_stream = sc.next();
            
        }
        
        String cur = "";
        
        for (int i=0 ; i<comp_stream.length() ; i++)
        {
            cur+= comp_stream.charAt(i);
            
            for (int j = 0; j < table.size(); j++)
            {
                if (table.get(j).get_code().equals(cur)) // law l code eli 2arah howa nfso eli mwgod fel table hayktb el 7rf bta3o we ya5od el code eli b3do 
                {
                    res += table.get(j).get_letter();
                    cur = "";
                    break;
                }
            }
            
        }

        write_res();
        close_file();
         
    }

    public void write_res() {

        openfile("Original Data.txt"); // 34an aktb el data b3d ma fakenaha
        out.format("%s", res);
        out.flush();
        closefile();

    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        read_file("Original Data.txt"); // compress data
    }//GEN-LAST:event_jButton1ActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        decrypt();

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Huffman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Huffman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Huffman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Huffman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Huffman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

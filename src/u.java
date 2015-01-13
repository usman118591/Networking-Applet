import java.applet.AppletContext;
import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class u extends JApplet {
   private HashMap<String, URL> websiteInfo;
   private ArrayList<String> titles;
   private JList mainList;
   //init Method
   public void init(){
	   websiteInfo=new HashMap<String,URL>();
	   titles=new ArrayList<String>();
	
	   grabHtmlInfo();//Importing html file made in our computer and converting into HAshtags and ArrayList.
   add(new JLabel("Pick any Website you want to Open!"),BorderLayout.NORTH);
   mainList=new JList(titles.toArray());
   mainList.addListSelectionListener(
    new ListSelectionListener(){
   public void valueChange(ListSelectionEvent event){
	   //Selects the Link in our Program
	   Object object=mainList.getSelectedValue();
 URL newDocument=websiteInfo.get(object);
 AppletContext browser=getAppletContext();
 browser.showDocument(newDocument);//Show Documentt show webpage
   }

@Override
public void valueChanged(ListSelectionEvent e) {
	// TODO Auto-generated method stub
	
}
   
   }
   );
}
   //get website info;
   private void grabHtmlInfo(){
	     String title;
	     String address;
	     URL url;
	     int counter=0;
	     title= getParameter("title+counter");
	     while(title !=null){
	    	 address=getParameter("address"+counter);
	    	 try {
				url=new URL(address);
				websiteInfo.put(title, url);
				titles.add(title);
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     ++counter;
	     title= getParameter("Title"+counter);
	     
	     }
	     
   }
}

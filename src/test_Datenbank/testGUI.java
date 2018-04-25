package test_Datenbank;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;

import javax.swing.*;


public class testGUI {
	public DB getVb() {
		return vb;
	}


	public void setVb(DB vb) {
		this.vb = vb;
	}


	private JFrame jf=null;
	private JTabbedPane tp=null;
	
	private JPanel p1=null;
	private JPanel p2=null;
	private JPanel p3=null;
	private JPanel p4=null;
	private JLabel l1=null;
	
	private JPanel p5=null;
	private JPanel p6=null;
	private JPanel p7=null;
	private JPanel p8=null;
	
	private JPanel p9=null;
	private JPanel p10=null;
	private JPanel p11=null;
	private JPanel p12=null;
	
	private JPanel p13=null;
	private JPanel p14=null;
	private JPanel p15=null;
	private JPanel p16=null;
	
	private JPanel p17=null;
	private JPanel p18=null;
	private JPanel p19=null;
	private JPanel p20=null;
	
	private JPanel p21=null;
	private JPanel p22=null;
	private JPanel p23=null;
	private JPanel p24=null;
	
	private JPanel p25=null;
	private JPanel p26=null;
	private JPanel p27=null;
	private JPanel p28=null;
	
	private JPanel p29=null;
	private JPanel p30=null;
	private JPanel p31=null;
	private JPanel p32=null;
	
	private JPanel p33=null;
	private JPanel p34=null;
	private JPanel p35=null;
	private JPanel p36=null;
	
	private TextField ktf1=null;
	private TextField ktf2=null;
	private TextField ktf3=null;
	private TextField ktf4=null;
	private TextField ktf5=null;
	
	private TextField ktf6=null;
	private TextField ktf7=null;
	private TextField ktf8=null;
	private TextField ktf9=null;
	private TextField ktf10=null;
	
	private TextField rtf1=null;
	private TextField rtf2=null;
	private TextField rtf3=null;
	private TextField rtf4=null;
	private TextField rtf5=null;
	
	private TextField rtf6=null;
	private TextField rtf7=null;
	private TextField rtf8=null;
	private TextField rtf9=null;
	private TextField rtf10=null;
	
	private TextField gktf1=null;
	private TextField gktf2=null;
	private TextField gktf3=null;
	
	private TextField gktf4=null;
	private TextField gktf5=null;
	private TextField gktf6=null;
	
	private TextField atf1=null;
	private TextField atf2=null;
	private TextField atf3=null;
	private TextField atf4=null;
	private TextField atf5=null;
	
	private TextField atf6=null;
	private TextField atf7=null;
	private TextField atf8=null;
	private TextField atf9=null;
	private TextField atf10=null;
	
	private TextField rptf1=null;
	private TextField rptf2=null;
	private TextField rptf3=null;
	private TextField rptf4=null;
	
	private TextField rptf5=null;
	private TextField rptf6=null;
	private TextField rptf7=null;
	private TextField rptf8=null;
	
	private TextField uftf1=null;
	private TextField uftf2=null;
	
	private TextField artf1=null;
	private TextField artf2=null;
	private TextField artf3=null;
	private TextField artf4=null;
	
	private TextField latf1=null;
	private TextField latf2=null;
	private TextField latf3=null;
	private TextField latf4=null;
	
	private TextField zatf1=null;
	private TextField zatf2=null;
	private TextField zatf3=null;
	private TextField zatf4=null;
	
	private JButton kSende=null;
	private JButton kÄndern=null;
	private JButton kLösche=null;
	
	private JButton rSende=null;
	private JButton rÄndern=null;
	private JButton rLösche=null;
	
	private JButton gkSende=null;
	private JButton gkÄndern=null;
	private JButton gkLösche=null;
	
	private JButton aSende=null;
	private JButton aÄndern=null;
	private JButton aLösche=null;
	
	private JButton rpSende=null;
	private JButton rpÄndern=null;
	private JButton rpLösche=null;
	
	private JButton ufSende=null;
	private JButton ufÄndern=null;
	private JButton ufLösche=null;
	
	private JButton arSende=null;
	private JButton arÄndern=null;
	private JButton arLösche=null;
	
	private JButton laSende=null;
	private JButton laÄndern=null;
	private JButton laLösche=null;
	
	private JButton zaSende=null;
	private JButton zaÄndern=null;
	private JButton zaLösche=null;

	private JLabel kDatensatz=null;
	private JLabel rDatensatz=null;
	private JLabel gkDatensatz=null;
	private JLabel aDatensatz=null;
	private JLabel rpDatensatz=null;
	private JLabel ufDatensatz=null;
	private JLabel arDatensatz=null;
	private JLabel laDatensatz=null;
	private JLabel zaDatensatz=null;
	
	private DB vb=null;
	
	public testGUI(DB vb){
		
		this.vb=vb;
		
		
		jf=new JFrame("Rechnungsverwaltung");
		tp=new JTabbedPane();
		
		//--------------------Kunde--------------------------
		
		vb.setSQL("SELECT * FROM kunde");
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		
		kSende=new JButton("Absenden");
		kSende.addActionListener(new EventHandlerButtons(this));
		kLösche=new JButton("Löschen");
		kLösche.addActionListener(new EventHandlerButtons(this));
		kDatensatz=new JLabel(vb.lesenJava());
		kDatensatz.setSize(50, 700);
		kÄndern=new JButton("Ändern");
		
		ktf1=new TextField("Vorname");
		ktf2=new TextField("Nachname");
		ktf3=new TextField("Email");
		ktf4=new TextField("Telefonnummer");
		ktf5=new TextField("AN_ID");
		
		ktf6=new TextField("Vorname");
		ktf7=new TextField("Nachname");
		ktf8=new TextField("Email");
		ktf9=new TextField("Telefonnummer");
		ktf10=new TextField("AN_ID");
		
		p1.setLayout(new GridLayout());
		p2.setLayout(new GridLayout(10,4));
		p3.setLayout(new GridLayout(1,1));
		p4.setLayout(new GridLayout(10,4));
	
		p1.add(p2);
		p1.add(p3);
		p1.add(p4);
		p2.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p2.add(ktf1);
		p2.add(ktf2);
		p2.add(ktf3);
		p2.add(ktf4);
		p2.add(ktf5);
		p2.add(kSende);
		p2.add(kLösche);
		
		p3.add(new JLabel(vb.lesenJava()));
		
		p4.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p4.add(ktf6);
		p4.add(ktf7);
		p4.add(ktf8);
		p4.add(ktf9);
		p4.add(ktf10);
		p4.add(kÄndern);
		
		tp.add("Kunde", p1);
		
		//-------------------------------------------------------
		//------------------Rechnung-----------------------------
		vb.setSQL("SELECT * FROM rechnung");
		
		p5 =new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		
		rSende=new JButton("Absenden");
		rSende.addActionListener(new EventHandlerButtons(this));
		rLösche=new JButton("Löschen");
		rLösche.addActionListener(new EventHandlerButtons(this));
		rDatensatz=new JLabel("<datensatz>");
		rÄndern=new JButton("Ändern");
		
		rtf1=new TextField("Datum");
		rtf2=new TextField("Bezahlt");
		rtf3=new TextField("Zahlungsziel");
		rtf4=new TextField("Kundenummer");
		rtf5=new TextField("Transaktionsnumer");
		
		rtf6=new TextField("Datum");
		rtf7=new TextField("Bezahlt");
		rtf8=new TextField("Zahlungsziel");
		rtf9=new TextField("Kundenummer");
		rtf10=new TextField("Transaktionsnummer");
		
		p5.setLayout(new GridLayout());
		p6.setLayout(new GridLayout(10,4));
		p7.setLayout(new GridLayout(1,1));
		p8.setLayout(new GridLayout(10,4));
		
		p5.add(p6);
		p5.add(p7);
		p5.add(p8);
		
		p6.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p6.add(rtf1);
		p6.add(rtf2);
		p6.add(rtf3);
		p6.add(rtf4);
		p6.add(rtf5);
		p6.add(rSende);
		p6.add(rLösche);
		
		p7.add(new JLabel(vb.lesenJava()));
			
		p8.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p8.add(rtf6);
		p8.add(rtf7);
		p8.add(rtf8);
		p8.add(rtf9);
		p8.add(rtf10);
		p8.add(rÄndern);
		
		tp.add("Rechnung", p5);
		
		//------------------------------------------------------
		//--------------Geschäftskunde
		vb.setSQL("SELECT * FROM geschäftskunde");
		
		p9 =new JPanel();
		p10=new JPanel();
		p11=new JPanel();
		p12=new JPanel();
		
		gkSende=new JButton("Absenden");
		gkSende.addActionListener(new EventHandlerButtons(this));
		gkLösche=new JButton("Löschen");
		gkLösche.addActionListener(new EventHandlerButtons(this));
		gkDatensatz=new JLabel("<datensatz>");
		gkÄndern=new JButton("Ändern");
		
		gktf1=new TextField("Kundennummer");
		gktf2=new TextField("Firmenname");
		gktf3=new TextField("RechtsformID");
		
		gktf4=new TextField("Kundennummer");
		gktf5=new TextField("Firmenname");
		gktf6=new TextField("RechtsformID");
		
		
		p9.setLayout(new GridLayout());
		p10.setLayout(new GridLayout(10,4));
		p11.setLayout(new GridLayout(1,1));
		p12.setLayout(new GridLayout(10,4));
		
		p9.add(p10);
		p9.add(p11);
		p9.add(p12);
		
		p10.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p10.add(gktf1);
		p10.add(gktf2);
		p10.add(gktf3);
		p10.add(gkSende);
		p10.add(gkLösche);
		
		p11.add(new JLabel(vb.lesenJava()));
	
		p12.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p12.add(gktf4);
		p12.add(gktf5);
		p12.add(gktf6);
		p12.add(gkÄndern);
		
		tp.add("Geschäftskunde", p9);
		
		//---------------------------------------------------------------------------------
		//-----------------------------Anschrift-------------------------------------------
		vb.setSQL("SELECT * FROM anschrift");

		p13 =new JPanel();
		p14=new JPanel();
		p15=new JPanel();
		p16=new JPanel();
		
		aSende=new JButton("Absenden");
		aSende.addActionListener(new EventHandlerButtons(this));
		aLösche=new JButton("Löschen");
		aLösche.addActionListener(new EventHandlerButtons(this));
		aDatensatz=new JLabel("<datensatz>");
		aÄndern=new JButton("Ändern");
		
		atf1=new TextField("Strasse");
		atf2=new TextField("Nummer");
		atf3=new TextField("PLZ");
		atf4=new TextField("Ort");
		atf5=new TextField("LandID");
		
		atf6=new TextField("Strasse");
		atf7=new TextField("Nummer");
		atf8=new TextField("PLZ");
		atf9=new TextField("Ort");
		atf10=new TextField("LandID");
		
		p13.setLayout(new GridLayout());
		p14.setLayout(new GridLayout(10,4));
		p15.setLayout(new GridLayout(1,1));
		p16.setLayout(new GridLayout(10,4));
		
		p13.add(p14);
		p13.add(p15);
		p13.add(p16);
		
		p14.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p14.add(atf1);
		p14.add(atf2);
		p14.add(atf3);
		p14.add(atf4);
		p14.add(atf5);
		p14.add(aSende);
		p14.add(aLösche);
		
		p15.add(new JLabel(vb.lesenJava()));
		
		p16.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p16.add(atf6);
		p16.add(atf7);
		p16.add(atf8);
		p16.add(atf9);
		p16.add(atf10);
		p16.add(aÄndern);
		
		tp.add("Anschrift", p13);
		
		//--------------------------------------------------------------
		//---------------------Rechnungsposition------------------------
		
		vb.setSQL("SELECT * FROM rechnungsposition");

		p17 =new JPanel();
		p18=new JPanel();
		p19=new JPanel();
		p20=new JPanel();
		
		rpSende=new JButton("Absenden");
		rpSende.addActionListener(new EventHandlerButtons(this));
		rpLösche=new JButton("Löschen");
		rpLösche.addActionListener(new EventHandlerButtons(this));
		rpDatensatz=new JLabel("<datensatz>");
		rpÄndern=new JButton("Ändern");
		
		rptf1=new TextField("RechnungsID");
		rptf2=new TextField("Positionsnummer");
		rptf3=new TextField("ArtikelID");
		rptf4=new TextField("Menge");
		
		rptf5=new TextField("RechnungsID");
		rptf6=new TextField("Positionsnummer");
		rptf7=new TextField("ArtikelID");
		rptf8=new TextField("Menge");
		
		p17.setLayout(new GridLayout());
		p18.setLayout(new GridLayout(10,4));
		p19.setLayout(new GridLayout(1,1));
		p20.setLayout(new GridLayout(10,4));
		
		p17.add(p18);
		p17.add(p19);
		p17.add(p20);
		
		p18.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p18.add(rptf1);
		p18.add(rptf2);
		p18.add(rptf3);
		p18.add(rptf4);
		p18.add(rpSende);
		p18.add(rpLösche);
		
		p19.add(new JLabel(vb.lesenJava()));
		
		p20.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p20.add(rptf5);
		p20.add(rptf6);
		p20.add(rptf7);
		p20.add(rptf8);
		p20.add(rpÄndern);
		
		tp.add("Rechnungsposition", p17);
		
		//----------------------------------------------------------
		//---------------Unternehmensform---------------------------
		vb.setSQL("SELECT * FROM unternehmensform");

		p21 =new JPanel();
		p22=new JPanel();
		p23=new JPanel();
		p24=new JPanel();
		
		ufSende=new JButton("Absenden");
		ufLösche=new JButton("Löschen");
		ufDatensatz=new JLabel("<datensatz>");
		ufÄndern=new JButton("Ändern");
		
		uftf1=new TextField("Rechtsform");
		uftf2=new TextField("Rechtsform");
		
		p21.setLayout(new GridLayout());
		p22.setLayout(new GridLayout(10,4));
		p23.setLayout(new GridLayout(1,1));
		p24.setLayout(new GridLayout(10,4));
		
		p21.add(p22);
		p21.add(p23);
		p21.add(p24);
		
		p22.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p22.add(uftf1);
		p22.add(ufSende);
		p22.add(ufLösche);
		
		p23.add(new JLabel(vb.lesenJava()));
		
		p24.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p24.add(uftf2);
		p24.add(ufÄndern);
		
		tp.add("Unternehmensform", p21);
		
		//-------------------------------------------------------------------------------------
		//----------------------------Artikel--------------------------------------------------
		vb.setSQL("SELECT * FROM artikel");

		p25=new JPanel();
		p26=new JPanel();
		p27=new JPanel();
		p28=new JPanel();
		
		arSende=new JButton("Absenden");
		arLösche=new JButton("Löschen");
		arDatensatz=new JLabel("<datensatz>");
		arÄndern=new JButton("Ändern");
		
		artf1=new TextField("Bezeichung");
		artf2=new TextField("Preis");
		artf3=new TextField("Bezeichnung");
		artf4=new TextField("Preis");
		
		p25.setLayout(new GridLayout());
		p26.setLayout(new GridLayout(10,4));
		p27.setLayout(new GridLayout(1,1));
		p28.setLayout(new GridLayout(10,4));
		
		p25.add(p26);
		p25.add(p27);
		p25.add(p28);
		
		p26.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p26.add(artf1);
		p26.add(artf2);
		p26.add(arSende);
		p26.add(arLösche);
		
		p27.add(new JLabel(vb.lesenJava()));
		
		p28.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p28.add(artf3);
		p28.add(artf4);
		p28.add(arÄndern);
		
		tp.add("Artikel", p25);
		
		//--------------------------------------------------------------------------------
		//-------------------------Land---------------------------------------------------
		
		vb.setSQL("SELECT * FROM land");

		p29=new JPanel();
		p30=new JPanel();
		p31=new JPanel();
		p32=new JPanel();
		
		laSende=new JButton("Absenden");
		laSende.addActionListener(new EventHandlerButtons(this));
		laLösche=new JButton("Löschen");
		laLösche.addActionListener(new EventHandlerButtons(this));
		laDatensatz=new JLabel("<datensatz>");
		laÄndern=new JButton("Ändern");
		
		latf1=new TextField("ID");
		latf2=new TextField("Land");
		latf3=new TextField("ID");
		latf4=new TextField("Land");
		
		p29.setLayout(new GridLayout());
		p30.setLayout(new GridLayout(10,4));
		p31.setLayout(new GridLayout(1,1));
		p32.setLayout(new GridLayout(10,4));
		
		p29.add(p30);
		p29.add(p31);
		p29.add(p32);
		
		p30.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p30.add(latf1);
		p30.add(latf2);
		p30.add(laSende);
		p30.add(laLösche);
		
		p31.add(new JLabel(vb.lesenJava()));
		
		p32.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p32.add(latf3);
		p32.add(latf4);
		p32.add(laÄndern);
		
		tp.add("Land", p29);
		
		//----------------------------------------------------------------------------------------
		//------------------------------------- Zahlungsart---------------------------------------
		
		vb.setSQL("SELECT * FROM zahlungsart");

		p33=new JPanel();
		p34=new JPanel();
		p35=new JPanel();
		p36=new JPanel();
		
		zaSende=new JButton("Absenden");
		zaLösche=new JButton("Löschen");
		zaDatensatz=new JLabel("<datensatz>");
		zaÄndern=new JButton("Ändern");
		
		zatf1=new TextField("ZANr");
		zatf2=new TextField("KDNr");
		zatf3=new TextField("ZANr");
		zatf4=new TextField("KDNr");
		
		p33.setLayout(new GridLayout());
		p34.setLayout(new GridLayout(10,4));
		p35.setLayout(new GridLayout(1,1));
		p36.setLayout(new GridLayout(10,4));
		
		p33.add(p34);
		p33.add(p35);
		p33.add(p36);
		
		p34.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p34.add(zatf1);
		p34.add(zatf2);
		p34.add(zaSende);
		p34.add(zaLösche);
		
		p35.add(new JLabel(vb.lesenJava()));
		
		p36.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p36.add(zatf3);
		p36.add(zatf4);
		p36.add(zaÄndern);
		
		tp.add("Zahlungsart", p33);
		
		//-----------------------------------------------------------------------------------------------
		
		
		
		
		
		
		jf.add(tp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		
	}
	

	public JButton getaSende() {
		return aSende;
	}


	public void setaSende(JButton aSende) {
		this.aSende = aSende;
	}


	public JButton getaÄndern() {
		return aÄndern;
	}


	public void setaÄndern(JButton aÄndern) {
		this.aÄndern = aÄndern;
	}


	public JButton getaLösche() {
		return aLösche;
	}


	public void setaLösche(JButton aLösche) {
		this.aLösche = aLösche;
	}


	public JLabel getaDatensatz() {
		return aDatensatz;
	}


	public void setaDatensatz(JLabel aDatensatz) {
		this.aDatensatz = aDatensatz;
	}


	public TextField getRtf1() {
		return rtf1;
	}


	public void setRtf1(TextField rtf1) {
		this.rtf1 = rtf1;
	}


	public TextField getRtf2() {
		return rtf2;
	}


	public void setRtf2(TextField rtf2) {
		this.rtf2 = rtf2;
	}


	public TextField getRtf3() {
		return rtf3;
	}


	public void setRtf3(TextField rtf3) {
		this.rtf3 = rtf3;
	}


	public TextField getRtf4() {
		return rtf4;
	}


	public void setRtf4(TextField rtf4) {
		this.rtf4 = rtf4;
	}


	public TextField getRtf5() {
		return rtf5;
	}


	public void setRtf5(TextField rtf5) {
		this.rtf5 = rtf5;
	}


	public TextField getRtf6() {
		return rtf6;
	}


	public void setRtf6(TextField rtf6) {
		this.rtf6 = rtf6;
	}


	public TextField getRtf7() {
		return rtf7;
	}


	public void setRtf7(TextField rtf7) {
		this.rtf7 = rtf7;
	}


	public TextField getRtf8() {
		return rtf8;
	}


	public void setRtf8(TextField rtf8) {
		this.rtf8 = rtf8;
	}


	public TextField getRtf9() {
		return rtf9;
	}


	public void setRtf9(TextField rtf9) {
		this.rtf9 = rtf9;
	}


	public TextField getRtf10() {
		return rtf10;
	}


	public void setRtf10(TextField rtf10) {
		this.rtf10 = rtf10;
	}


	public JButton getrSende() {
		return rSende;
	}


	public void setrSende(JButton rSende) {
		this.rSende = rSende;
	}


	public JButton getrLösche() {
		return rLösche;
	}


	public void setrLösche(JButton rLösche) {
		this.rLösche = rLösche;
	}


	public JButton getkLösche() {
		return kLösche;
	}


	public void setkLösche(JButton kLösche) {
		this.kLösche = kLösche;
	}


	public JButton getkSende() {
		return kSende;
	}




	public TextField getKtf1() {
		return ktf1;
	}


	public void setKtf1(TextField ktf1) {
		this.ktf1 = ktf1;
	}


	public TextField getKtf2() {
		return ktf2;
	}


	public void setKtf2(TextField ktf2) {
		this.ktf2 = ktf2;
	}


	public TextField getKtf3() {
		return ktf3;
	}


	public void setKtf3(TextField ktf3) {
		this.ktf3 = ktf3;
	}


	public TextField getKtf4() {
		return ktf4;
	}


	public void setKtf4(TextField ktf4) {
		this.ktf4 = ktf4;
	}


	public TextField getKtf5() {
		return ktf5;
	}


	public void setKtf5(TextField ktf5) {
		this.ktf5 = ktf5;
	}


	public TextField getAtf1() {
		return atf1;
	}


	public void setAtf1(TextField atf1) {
		this.atf1 = atf1;
	}


	public TextField getAtf2() {
		return atf2;
	}


	public void setAtf2(TextField atf2) {
		this.atf2 = atf2;
	}


	public TextField getAtf3() {
		return atf3;
	}


	public void setAtf3(TextField atf3) {
		this.atf3 = atf3;
	}


	public TextField getAtf4() {
		return atf4;
	}


	public void setAtf4(TextField atf4) {
		this.atf4 = atf4;
	}


	public TextField getAtf5() {
		return atf5;
	}


	public void setAtf5(TextField atf5) {
		this.atf5 = atf5;
	}

	

	public TextField getGktf6() {
		return gktf6;
	}


	public void setGktf6(TextField gktf6) {
		this.gktf6 = gktf6;
	}


	public TextField getGktf1() {
		return gktf1;
	}


	public void setGktf1(TextField gktf1) {
		this.gktf1 = gktf1;
	}


	public TextField getGktf2() {
		return gktf2;
	}


	public void setGktf2(TextField gktf2) {
		this.gktf2 = gktf2;
	}


	public TextField getGktf3() {
		return gktf3;
	}


	public void setGktf3(TextField gktf3) {
		this.gktf3 = gktf3;
	}


	public TextField getGktf4() {
		return gktf4;
	}


	public void setGktf4(TextField gktf4) {
		this.gktf4 = gktf4;
	}


	public TextField getGktf5() {
		return gktf5;
	}


	public void setGktf5(TextField gktf5) {
		this.gktf5 = gktf5;
	}


	public JButton getGkSende() {
		return gkSende;
	}


	public void setGkSende(JButton gkSende) {
		this.gkSende = gkSende;
	}


	public JButton getGkÄndern() {
		return gkÄndern;
	}


	public void setGkÄndern(JButton gkÄndern) {
		this.gkÄndern = gkÄndern;
	}


	public JButton getGkLösche() {
		return gkLösche;
	}


	public void setGkLösche(JButton gkLösche) {
		this.gkLösche = gkLösche;
	}


	public JLabel getGkDatensatz() {
		return gkDatensatz;
	}


	public void setGkDatensatz(JLabel gkDatensatz) {
		this.gkDatensatz = gkDatensatz;
	}
	
	
	
	


	public JButton getRpSende() {
		return rpSende;
	}


	public void setRpSende(JButton rpSende) {
		this.rpSende = rpSende;
	}


	public JButton getRpÄndern() {
		return rpÄndern;
	}


	public void setRpÄndern(JButton rpÄndern) {
		this.rpÄndern = rpÄndern;
	}


	public JButton getRpLösche() {
		return rpLösche;
	}


	public void setRpLösche(JButton rpLösche) {
		this.rpLösche = rpLösche;
	}


	public JLabel getRpDatensatz() {
		return rpDatensatz;
	}


	public void setRpDatensatz(JLabel rpDatensatz) {
		this.rpDatensatz = rpDatensatz;
	}
	
	


	public TextField getRptf1() {
		return rptf1;
	}


	public void setRptf1(TextField rptf1) {
		this.rptf1 = rptf1;
	}


	public TextField getRptf2() {
		return rptf2;
	}


	public void setRptf2(TextField rptf2) {
		this.rptf2 = rptf2;
	}


	public TextField getRptf3() {
		return rptf3;
	}


	public void setRptf3(TextField rptf3) {
		this.rptf3 = rptf3;
	}


	public TextField getRptf4() {
		return rptf4;
	}


	public void setRptf4(TextField rptf4) {
		this.rptf4 = rptf4;
	}


	public TextField getRptf5() {
		return rptf5;
	}


	public void setRptf5(TextField rptf5) {
		this.rptf5 = rptf5;
	}


	public TextField getRptf6() {
		return rptf6;
	}


	public void setRptf6(TextField rptf6) {
		this.rptf6 = rptf6;
	}


	public TextField getRptf7() {
		return rptf7;
	}


	public void setRptf7(TextField rptf7) {
		this.rptf7 = rptf7;
	}


	public TextField getRptf8() {
		return rptf8;
	}


	public void setRptf8(TextField rptf8) {
		this.rptf8 = rptf8;
	}
	
	


	public TextField getLatf1() {
		return latf1;
	}


	public void setLatf1(TextField latf1) {
		this.latf1 = latf1;
	}


	public TextField getLatf2() {
		return latf2;
	}


	public void setLatf2(TextField latf2) {
		this.latf2 = latf2;
	}


	public TextField getLatf3() {
		return latf3;
	}


	public void setLatf3(TextField latf3) {
		this.latf3 = latf3;
	}


	public TextField getLatf4() {
		return latf4;
	}


	public void setLatf4(TextField latf4) {
		this.latf4 = latf4;
	}


	public JButton getLaSende() {
		return laSende;
	}


	public void setLaSende(JButton laSende) {
		this.laSende = laSende;
	}


	public JButton getLaÄndern() {
		return laÄndern;
	}


	public void setLaÄndern(JButton laÄndern) {
		this.laÄndern = laÄndern;
	}


	public JButton getLaLösche() {
		return laLösche;
	}


	public void setLaLösche(JButton laLösche) {
		this.laLösche = laLösche;
	}


	public JLabel getLaDatensatz() {
		return laDatensatz;
	}


	public void setLaDatensatz(JLabel laDatensatz) {
		this.laDatensatz = laDatensatz;
	}


	public static void main(String[] args) {
		DB d=new DB();
		new testGUI(d);

	}

}

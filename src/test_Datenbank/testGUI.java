package test_Datenbank;
//import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
//import java.awt.event.ActionListener;
import java.sql.SQLException;
//import java.util.Collection;

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
	//private JLabel l1=null;
	
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
	
	private JPanel p37=null;
	private JPanel p38=null;
	private JPanel p39=null;
	private JPanel p40=null;
	
	private JPanel p41=null;
	private JPanel p42=null;
	private JPanel p43=null;
	private JPanel p44=null;
	
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
	
	@SuppressWarnings("rawtypes")
	private JComboBox kCb=null;
	@SuppressWarnings("rawtypes")
	private JComboBox rCb=null;
	@SuppressWarnings("rawtypes")
	private JComboBox gkCb=null;
	@SuppressWarnings("rawtypes")
	private JComboBox anCb=null;
	@SuppressWarnings("rawtypes")
	private JComboBox arCb=null;
	@SuppressWarnings("rawtypes")
	private JComboBox laCb=null;
	@SuppressWarnings("rawtypes")
	private JComboBox ufCb=null;
	@SuppressWarnings("rawtypes")
	private JComboBox rpCb=null;
	@SuppressWarnings("rawtypes")
	private JComboBox zaCb=null;
	@SuppressWarnings("rawtypes")
	private JComboBox beCb=null;
	@SuppressWarnings("rawtypes")
	private JComboBox kkCb=null;
	
	
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
	
	private TextField betf1=null;
	private TextField betf2=null;
	private TextField betf3=null;
	private TextField betf4=null;
	
	private TextField kktf1=null;
	private TextField kktf2=null;
	private TextField kktf3=null;
	private TextField kktf4=null;
	
	private JButton kSende=null;
	private JButton k�ndern=null;
	private JButton kL�sche=null;
	private JButton kAktualisiere=null;
	
	private JButton rSende=null;
	private JButton r�ndern=null;
	private JButton rL�sche=null;
	private JButton rAktualisiere=null;
	
	private JButton gkSende=null;
	private JButton gk�ndern=null;
	private JButton gkL�sche=null;
	private JButton gkAktualisiere=null;
	
	private JButton aSende=null;
	private JButton a�ndern=null;
	private JButton aL�sche=null;
	private JButton aAktualisiere=null;
	
	private JButton rpSende=null;
	private JButton rp�ndern=null;
	private JButton rpL�sche=null;
	private JButton rpAktualisiere=null;
	
	private JButton ufSende=null;
	private JButton uf�ndern=null;
	private JButton ufL�sche=null;
	private JButton ufAktualisiere=null;
	
	private JButton arSende=null;
	private JButton ar�ndern=null;
	private JButton arL�sche=null;
	private JButton arAktualisiere=null;
	
	private JButton laSende=null;
	private JButton la�ndern=null;
	private JButton laL�sche=null;
	private JButton laAktualisiere=null;
	
	private JButton zaSende=null;
	private JButton za�ndern=null;
	private JButton zaL�sche=null;
	private JButton zaAktualisiere=null;
	
	private JButton beSende=null;
	private JButton be�ndern=null;
	private JButton beL�sche=null;
	private JButton beAktualisiere=null;
	
	private JButton kkSende=null;
	private JButton kk�ndern=null;
	private JButton kkL�sche=null;
	private JButton kkAktualisiere=null;


	private JLabel kDatensatz=null;
	private JLabel rDatensatz=null;
	private JLabel gkDatensatz=null;
	private JLabel aDatensatz=null;
	private JLabel rpDatensatz=null;
	private JLabel ufDatensatz=null;
	private JLabel arDatensatz=null;
	private JLabel laDatensatz=null;
	private JLabel zaDatensatz=null;
	private JLabel beDatensatz=null;
	private JLabel kkDatensatz=null;
	
	private DB vb=null;
	
	public testGUI(DB vb) throws SQLException{
		
		this.vb=vb;
		
		
		jf=new JFrame("Rechnungsverwaltung");
		tp=new JTabbedPane();
		//--------------------Kunde--------------------------
		
		vb.setSQL("SELECT * FROM kunde");
		KundenListe.getkundenListe().kundenListeAktualisieren(vb);
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		
		kSende=new JButton("Absenden");
		kSende.addActionListener(new EventHandlerButtons(this));
		kL�sche=new JButton("L�schen");
		kL�sche.addActionListener(new EventHandlerButtons(this));
		kDatensatz=new JLabel("<Datensatz>");
		//kDatensatz.setSize(50, 700);
		k�ndern=new JButton("�ndern");
		k�ndern.addActionListener(new EventHandlerButtons(this));
		kAktualisiere=new JButton("Anzeige aktualisieren");
		kAktualisiere.addActionListener(new EventHandlerAktualisieren(this));
		
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
		
		kCb=new JComboBox(KundenListe.getkundenListe().getkListe().toArray());
		kCb.addActionListener(new EventHandlerJComboBoxes(this));
		kDatensatz.setText(KundenListe.getkundenListe().toString());
		
		p1.setLayout(new GridLayout());
		p2.setLayout(new GridLayout(10,4));
		p3.setLayout(new GridLayout(1,1));
		p4.setLayout(new GridLayout(10,4));
	
		p1.add(p2);
		p1.add(p3);
		p1.add(p4);
		p2.add(new JLabel("<html><span style='font-size:15px'>Datensatz einf�gen oder l�schen</span></html>"));
		p2.add(ktf1);
		p2.add(ktf2);
		p2.add(ktf3);
		p2.add(ktf4);
		p2.add(ktf5);
		p2.add(kSende);
		p2.add(kL�sche);
		
		p3.add(kDatensatz);
		
		p4.add(new JLabel("<html><span style='font-size:15px'>Datensatz �ndern</span></html>"));
		p4.add(kCb);
		p4.add(ktf6);
		p4.add(ktf7);
		p4.add(ktf8);
		p4.add(ktf9);
		p4.add(ktf10);
		p4.add(k�ndern);
		p4.add(kAktualisiere);
		
		tp.add("Kunde", p1);
		
		//-------------------------------------------------------
		//------------------Rechnung-----------------------------
		vb.setSQL("SELECT * FROM rechnung");
		RechnungsListe.getRechnungsListe().rechnungsListeAktualisieren(vb);
		p5 =new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		
		rSende=new JButton("Absenden");
		rSende.addActionListener(new EventHandlerButtons(this));
		rL�sche=new JButton("L�schen");
		rL�sche.addActionListener(new EventHandlerButtons(this));
		rDatensatz=new JLabel("<datensatz>");
		r�ndern=new JButton("�ndern");
		r�ndern.addActionListener(new EventHandlerButtons(this));
		rAktualisiere=new JButton("Anzeige aktualisieren");
		rAktualisiere.addActionListener(new EventHandlerAktualisieren(this));
		
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
		
		rCb=new JComboBox(RechnungsListe.getRechnungsListe().getRListe().toArray());
		rCb.addActionListener(new EventHandlerJComboBoxes(this));
		rDatensatz.setText(RechnungsListe.getRechnungsListe().toString());
		
		p5.setLayout(new GridLayout());
		p6.setLayout(new GridLayout(10,4));
		p7.setLayout(new GridLayout(1,1));
		p8.setLayout(new GridLayout(10,4));
		
		p5.add(p6);
		p5.add(p7);
		p5.add(p8);
		
		p6.add(new JLabel("<html><span style='font-size:15px'>Datensatz einf�gen oder l�schen</span></html>"));
		p6.add(rtf1);
		p6.add(rtf2);
		p6.add(rtf3);
		p6.add(rtf4);
		p6.add(rtf5);
		p6.add(rSende);
		p6.add(rL�sche);
		
		p7.add(rDatensatz);
			
		p8.add(new JLabel("<html><span style='font-size:15px'>Datensatz �ndern</span></html>"));
		p8.add(rCb);
		p8.add(rtf6);
		p8.add(rtf7);
		p8.add(rtf8);
		p8.add(rtf9);
		p8.add(rtf10);
		p8.add(r�ndern);
		p8.add(rAktualisiere);
		
		tp.add("Rechnung", p5);
		
		//------------------------------------------------------
		//--------------Gesch�ftskunde
		vb.setSQL("SELECT * FROM gesch�ftskunde");
		GeschaeftskundenListe.getGeschaeftskundenListe().geschaeftskundenListeAktualisieren(vb);
		
		p9 =new JPanel();
		p10=new JPanel();
		p11=new JPanel();
		p12=new JPanel();
		
		gkSende=new JButton("Absenden");
		gkSende.addActionListener(new EventHandlerButtons(this));
		gkL�sche=new JButton("L�schen");
		gkL�sche.addActionListener(new EventHandlerButtons(this));
		gkDatensatz=new JLabel("<datensatz>");
		gk�ndern=new JButton("�ndern");
		gk�ndern.addActionListener(new EventHandlerButtons(this));
		gkAktualisiere=new JButton("Anzeige aktualisieren");
		gkAktualisiere.addActionListener(new EventHandlerAktualisieren(this));
		
		gktf1=new TextField("Kundennummer");
		gktf2=new TextField("Firmenname");
		gktf3=new TextField("RechtsformID");
		
		gktf4=new TextField("Kundennummer");
		gktf5=new TextField("Firmenname");
		gktf6=new TextField("RechtsformID");
		
		gkCb=new JComboBox(GeschaeftskundenListe.getGeschaeftskundenListe().getGkListe().toArray());
		gkCb.addActionListener(new EventHandlerJComboBoxes(this));
		gkDatensatz.setText(GeschaeftskundenListe.getGeschaeftskundenListe().toString());
		
		
		p9.setLayout(new GridLayout());
		p10.setLayout(new GridLayout(10,4));
		p11.setLayout(new GridLayout(1,1));
		p12.setLayout(new GridLayout(10,4));
		
		p9.add(p10);
		p9.add(p11);
		p9.add(p12);
		
		p10.add(new JLabel("<html><span style='font-size:15px'>Datensatz einf�gen oder l�schen</span></html>"));
		p10.add(gktf1);
		p10.add(gktf2);
		p10.add(gktf3);
		p10.add(gkSende);
		p10.add(gkL�sche);
		
		p11.add(gkDatensatz);
	
		p12.add(new JLabel("<html><span style='font-size:15px'>Datensatz �ndern</span></html>"));
		p12.add(gkCb);
		p12.add(gktf4);
		p12.add(gktf5);
		p12.add(gktf6);
		p12.add(gk�ndern);
		p12.add(gkAktualisiere);
		
		tp.add("Gesch�ftskunde", p9);
		
		//---------------------------------------------------------------------------------
		//-----------------------------Anschrift-------------------------------------------
		vb.setSQL("SELECT * FROM anschrift");
		AnschriftenListe.getAnschriftenListe().anschriftenListeAktualisieren(vb);
		
		p13 =new JPanel();
		p14=new JPanel();
		p15=new JPanel();
		p16=new JPanel();
		
		aSende=new JButton("Absenden");
		aSende.addActionListener(new EventHandlerButtons(this));
		aL�sche=new JButton("L�schen");
		aL�sche.addActionListener(new EventHandlerButtons(this));
		aDatensatz=new JLabel("<datensatz>");
		a�ndern=new JButton("�ndern");
		a�ndern.addActionListener(new EventHandlerButtons(this));
		aAktualisiere=new JButton("Anzeige aktualisieren");
		aAktualisiere.addActionListener(new EventHandlerAktualisieren(this));
		
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
		
		anCb=new JComboBox(AnschriftenListe.getAnschriftenListe().getaListe().toArray());
		anCb.addActionListener(new EventHandlerJComboBoxes(this));
		aDatensatz.setText(AnschriftenListe.getAnschriftenListe().toString());
		
		p13.setLayout(new GridLayout());
		p14.setLayout(new GridLayout(10,4));
		p15.setLayout(new GridLayout(1,1));
		p16.setLayout(new GridLayout(10,4));
		
		p13.add(p14);
		p13.add(p15);
		p13.add(p16);
		
		p14.add(new JLabel("<html><span style='font-size:15px'>Datensatz einf�gen oder l�schen</span></html>"));
		p14.add(atf1);
		p14.add(atf2);
		p14.add(atf3);
		p14.add(atf4);
		p14.add(atf5);
		p14.add(aSende);
		p14.add(aL�sche);
		
		p15.add(aDatensatz);
		
		p16.add(new JLabel("<html><span style='font-size:15px'>Datensatz �ndern</span></html>"));
		p16.add(anCb);
		p16.add(atf6);
		p16.add(atf7);
		p16.add(atf8);
		p16.add(atf9);
		p16.add(atf10);
		p16.add(a�ndern);
		p16.add(aAktualisiere);
		
		tp.add("Anschrift", p13);
		
		//--------------------------------------------------------------
		//---------------------Rechnungsposition------------------------
		
		vb.setSQL("SELECT * FROM rechnungsposition");
		RechnungspositionsListe.getRechnungspositionsListe().rechnungsPositionsListeAktualisieren(vb);
		
		p17 =new JPanel();
		p18=new JPanel();
		p19=new JPanel();
		p20=new JPanel();
		
		rpSende=new JButton("Absenden");
		rpSende.addActionListener(new EventHandlerButtons(this));
		rpL�sche=new JButton("L�schen");
		rpL�sche.addActionListener(new EventHandlerButtons(this));
		rpDatensatz=new JLabel("<datensatz>");
		rp�ndern=new JButton("�ndern");
		rp�ndern.addActionListener(new EventHandlerButtons(this));
		rpAktualisiere=new JButton("Anzeige aktualisieren");
		rpAktualisiere.addActionListener(new EventHandlerAktualisieren(this));
		
		rptf1=new TextField("RechnungsID");
		rptf2=new TextField("Positionsnummer");
		rptf3=new TextField("ArtikelID");
		rptf4=new TextField("Menge");
		
		rptf5=new TextField("RechnungsID");
		rptf6=new TextField("Positionsnummer");
		rptf7=new TextField("ArtikelID");
		rptf8=new TextField("Menge");
		
		rpCb=new JComboBox(RechnungspositionsListe.getRechnungspositionsListe().getRpListe().toArray());
		rpCb.addActionListener(new EventHandlerJComboBoxes(this));
		rpDatensatz.setText(RechnungspositionsListe.getRechnungspositionsListe().toString());
		
		p17.setLayout(new GridLayout());
		p18.setLayout(new GridLayout(10,4));
		p19.setLayout(new GridLayout(1,1));
		p20.setLayout(new GridLayout(10,4));
		
		p17.add(p18);
		p17.add(p19);
		p17.add(p20);
		
		p18.add(new JLabel("<html><span style='font-size:15px'>Datensatz einf�gen oder l�schen</span></html>"));
		p18.add(rptf1);
		p18.add(rptf2);
		p18.add(rptf3);
		p18.add(rptf4);
		p18.add(rpSende);
		p18.add(rpL�sche);
		
		p19.add(rpDatensatz);
		
		p20.add(new JLabel("<html><span style='font-size:15px'>Datensatz �ndern</span></html>"));
		p20.add(rpCb);
		p20.add(rptf5);
		p20.add(rptf6);
		p20.add(rptf7);
		p20.add(rptf8);
		p20.add(rp�ndern);
		p20.add(rpAktualisiere);
		
		tp.add("Rechnungsposition", p17);
		
		//----------------------------------------------------------
		//---------------Unternehmensform---------------------------
		vb.setSQL("SELECT * FROM unternehmensform");
		RechtsformListe.getRechtsformListe().rechtsformListeAktualisieren(vb);
		

		p21 =new JPanel();
		p22=new JPanel();
		p23=new JPanel();
		p24=new JPanel();
		
		ufSende=new JButton("Absenden");
		ufSende.addActionListener(new EventHandlerButtons(this));
		ufL�sche=new JButton("L�schen");
		ufL�sche.addActionListener(new EventHandlerButtons(this));
		ufDatensatz=new JLabel("<datensatz>");
		uf�ndern=new JButton("�ndern");
		uf�ndern.addActionListener(new EventHandlerButtons(this));
		ufAktualisiere=new JButton("Anzeige aktualisieren");
		ufAktualisiere.addActionListener(new EventHandlerAktualisieren(this));
		
		uftf1=new TextField("Rechtsform");
		uftf2=new TextField("Rechtsform");
		
		ufCb=new JComboBox(RechtsformListe.getRechtsformListe().getRfListe().toArray());
		ufCb.addActionListener(new EventHandlerJComboBoxes(this));
		ufDatensatz.setText(RechtsformListe.getRechtsformListe().toString());
		
		p21.setLayout(new GridLayout());
		p22.setLayout(new GridLayout(10,4));
		p23.setLayout(new GridLayout(1,1));
		p24.setLayout(new GridLayout(10,4));
		
		p21.add(p22);
		p21.add(p23);
		p21.add(p24);
		
		p22.add(new JLabel("<html><span style='font-size:15px'>Datensatz einf�gen oder l�schen</span></html>"));
		p22.add(uftf1);
		p22.add(ufSende);
		p22.add(ufL�sche);
		
		p23.add(ufDatensatz);
		
		p24.add(new JLabel("<html><span style='font-size:15px'>Datensatz �ndern</span></html>"));
		p24.add(ufCb);
		p24.add(uftf2);
		p24.add(uf�ndern);
		p24.add(ufAktualisiere);
		
		tp.add("Unternehmensform", p21);
		
		//-------------------------------------------------------------------------------------
		//----------------------------Artikel--------------------------------------------------
		vb.setSQL("SELECT * FROM artikel");
		ArtikelListe.getArtikelListe().artikelListeAktualisieren(vb);
		
		p25=new JPanel();
		p26=new JPanel();
		p27=new JPanel();
		p28=new JPanel();
		
		arSende=new JButton("Absenden");
		arSende.addActionListener(new EventHandlerButtons(this));
		arL�sche=new JButton("L�schen");
		arL�sche.addActionListener(new EventHandlerButtons(this));
		arDatensatz=new JLabel("<datensatz>");
		ar�ndern=new JButton("�ndern");
		ar�ndern.addActionListener(new EventHandlerButtons(this));
		arAktualisiere=new JButton("Anzeige aktualisieren");
		arAktualisiere.addActionListener(new EventHandlerAktualisieren(this));
		
		artf1=new TextField("Bezeichung");
		artf2=new TextField("Preis");
		artf3=new TextField("Bezeichnung");
		artf4=new TextField("Preis");
		
		arCb=new JComboBox(ArtikelListe.getArtikelListe().getaListe().toArray());
		arCb.addActionListener(new EventHandlerJComboBoxes(this));
		arDatensatz.setText(ArtikelListe.getArtikelListe().toString());
		
		p25.setLayout(new GridLayout());
		p26.setLayout(new GridLayout(10,4));
		p27.setLayout(new GridLayout(1,1));
		p28.setLayout(new GridLayout(10,4));
		
		p25.add(p26);
		p25.add(p27);
		p25.add(p28);
		
		p26.add(new JLabel("<html><span style='font-size:15px'>Datensatz einf�gen oder l�schen</span></html>"));
		p26.add(artf1);
		p26.add(artf2);
		p26.add(arSende);
		p26.add(arL�sche);
		
		p27.add(arDatensatz);
		
		p28.add(new JLabel("<html><span style='font-size:15px'>Datensatz �ndern</span></html>"));
		p28.add(arCb);
		p28.add(artf3);
		p28.add(artf4);
		p28.add(ar�ndern);
		p28.add(arAktualisiere);
		
		tp.add("Artikel", p25);
		
		//--------------------------------------------------------------------------------
		//-------------------------Land---------------------------------------------------
		
		vb.setSQL("SELECT * FROM land");
		LaenderListe.getLaenderListe().laenderListeAktualisieren(vb);
		
		p29=new JPanel();
		p30=new JPanel();
		p31=new JPanel();
		p32=new JPanel();
		
		laSende=new JButton("Absenden");
		laSende.addActionListener(new EventHandlerButtons(this));
		laL�sche=new JButton("L�schen");
		laL�sche.addActionListener(new EventHandlerButtons(this));
		laDatensatz=new JLabel("<datensatz>");
		la�ndern=new JButton("�ndern");
		la�ndern.addActionListener(new EventHandlerButtons(this));
		laAktualisiere=new JButton("Anzeige aktualisieren");
		laAktualisiere.addActionListener(new EventHandlerAktualisieren(this));
		
		latf1=new TextField("ID");
		latf2=new TextField("Land");
		latf3=new TextField("ID");
		latf4=new TextField("Land");
		
		laCb=new JComboBox(LaenderListe.getLaenderListe().getLaListe().toArray());
		laCb.addActionListener(new EventHandlerJComboBoxes(this));
		laDatensatz.setText(LaenderListe.getLaenderListe().toString());
		
		p29.setLayout(new GridLayout());
		p30.setLayout(new GridLayout(10,4));
		p31.setLayout(new GridLayout(1,1));
		p32.setLayout(new GridLayout(10,4));
		
		p29.add(p30);
		p29.add(p31);
		p29.add(p32);
		
		p30.add(new JLabel("<html><span style='font-size:15px'>Datensatz einf�gen oder l�schen</span></html>"));
		p30.add(latf1);
		p30.add(latf2);
		p30.add(laSende);
		p30.add(laL�sche);
		
		p31.add(laDatensatz);
		
		p32.add(new JLabel("<html><span style='font-size:15px'>Datensatz �ndern</span></html>"));
		p32.add(laCb);
		p32.add(latf3);
		p32.add(latf4);
		p32.add(la�ndern);
		p32.add(laAktualisiere);
		
		tp.add("Land", p29);
		
		//----------------------------------------------------------------------------------------
		//------------------------------------- Zahlungsart---------------------------------------
		
		vb.setSQL("SELECT * FROM zahlungsart");// ->wird eigl nicht mehr ben�tigt
		ZahlungsartListe.getZahlungsartListe().zahlungsartListeAktualisieren(vb);

		p33=new JPanel();
		p34=new JPanel();
		p35=new JPanel();
		p36=new JPanel();
		
		zaSende=new JButton("Absenden");
		zaSende.addActionListener(new EventHandlerButtons(this));
		zaL�sche=new JButton("L�schen");
		zaL�sche.addActionListener(new EventHandlerButtons(this));
		zaDatensatz=new JLabel("<datensatz>");
		za�ndern=new JButton("�ndern");
		za�ndern.addActionListener(new EventHandlerButtons(this));
		zaAktualisiere=new JButton("Anzeige aktualisieren");
		zaAktualisiere.addActionListener(new EventHandlerAktualisieren(this));
		
		zatf1=new TextField("ZANr");
		zatf2=new TextField("KDNr");
		zatf3=new TextField("ZANr");
		zatf4=new TextField("KDNr");
		
		zaCb=new JComboBox(ZahlungsartListe.getZahlungsartListe().getZaListe().toArray());
		zaCb.addActionListener(new EventHandlerJComboBoxes(this));
		zaDatensatz.setText(ZahlungsartListe.getZahlungsartListe().toString());
	
		p33.setLayout(new GridLayout());
		p34.setLayout(new GridLayout(10,4));
		p35.setLayout(new GridLayout(1,1));
		p36.setLayout(new GridLayout(10,4));
		
		p33.add(p34);
		p33.add(p35);
		p33.add(p36);
		
		p34.add(new JLabel("<html><span style='font-size:15px'>Datensatz einf�gen oder l�schen</span></html>"));
		p34.add(zatf1);
		p34.add(zatf2);
		p34.add(zaSende);
		p34.add(zaL�sche);
		
		p35.add(zaDatensatz);
		
		p36.add(new JLabel("<html><span style='font-size:15px'>Datensatz �ndern</span></html>"));
		p36.add(zaCb);
		p36.add(zatf3);
		p36.add(zatf4);
		p36.add(za�ndern);
		p36.add(zaAktualisiere);
		
		tp.add("Zahlungsart", p33);
		
		//-----------------------------------------------------------------------------------------------
		//-------------------------------------Bankeinzug---------------------------------------
		vb.setSQL("SELECT * FROM bankeinzug");// ->wird eigl nicht mehr ben�tigt
		BankeinzugListe.getBankeinzugListe().bankeinzugListeAktualisieren(vb);

		p37=new JPanel();
		p38=new JPanel();
		p39=new JPanel();
		p40=new JPanel();
		
		beSende=new JButton("Absenden");
		beSende.addActionListener(new EventHandlerButtons(this));
		beL�sche=new JButton("L�schen");
		beL�sche.addActionListener(new EventHandlerButtons(this));
		beDatensatz=new JLabel("<datensatz>");
		be�ndern=new JButton("�ndern");
		be�ndern.addActionListener(new EventHandlerButtons(this));
		beAktualisiere=new JButton("Anzeige aktualisieren");
		beAktualisiere.addActionListener(new EventHandlerAktualisieren(this));
		
		betf1=new TextField("IBAN");
		betf2=new TextField("BIC");
		betf3=new TextField("IBAN");
		betf4=new TextField("BIC");
		
		beCb=new JComboBox(BankeinzugListe.getBankeinzugListe().getbeListe().toArray());
		beCb.addActionListener(new EventHandlerJComboBoxes(this));
		beDatensatz.setText(BankeinzugListe.getBankeinzugListe().toString());
	
		p37.setLayout(new GridLayout());
		p38.setLayout(new GridLayout(10,4));
		p39.setLayout(new GridLayout(1,1));
		p40.setLayout(new GridLayout(10,4));
		
		p37.add(p38);
		p37.add(p39);
		p37.add(p40);
		
		p38.add(new JLabel("<html><span style='font-size:15px'>Datensatz einf�gen oder l�schen</span></html>"));
		p38.add(betf1);
		p38.add(betf2);
		p38.add(beSende);
		p38.add(beL�sche);
		
		p39.add(beDatensatz);
		
		p40.add(new JLabel("<html><span style='font-size:15px'>Datensatz �ndern</span></html>"));
		p40.add(beCb);
		p40.add(betf3);
		p40.add(betf4);
		p40.add(be�ndern);
		p40.add(beAktualisiere);
		
		tp.add("Bankeinzug", p37);
				
	  //-----------------------------------------------------------------------------------------------
	  //------------------------------------Kreditkarte---------------------------------------
		vb.setSQL("SELECT * FROM kreditkarte");// ->wird eigl nicht mehr ben�tigt
		KreditkarteListe.getKreditkarteListe().kreditkarteListeAktualisieren(vb);

		p41=new JPanel();
		p42=new JPanel();
		p43=new JPanel();
		p44=new JPanel();
		
		kkSende=new JButton("Absenden");
		kkSende.addActionListener(new EventHandlerButtons(this));
		kkL�sche=new JButton("L�schen");
		kkL�sche.addActionListener(new EventHandlerButtons(this));
		kkDatensatz=new JLabel("<datensatz>");
		kk�ndern=new JButton("�ndern");
		kk�ndern.addActionListener(new EventHandlerButtons(this));
		kkAktualisiere=new JButton("Anzeige aktualisieren");
		kkAktualisiere.addActionListener(new EventHandlerAktualisieren(this));
		
		kktf1=new TextField("KaNr");
		kktf2=new TextField("Ablaufdatum");
		kktf3=new TextField("KaNr");
		kktf4=new TextField("Ablaufdatum");
		
		kkCb=new JComboBox(KreditkarteListe.getKreditkarteListe().getkkListe().toArray());
		kkCb.addActionListener(new EventHandlerJComboBoxes(this));
		kkDatensatz.setText(KreditkarteListe.getKreditkarteListe().toString());
	
		p41.setLayout(new GridLayout());
		p42.setLayout(new GridLayout(10,4));
		p43.setLayout(new GridLayout(1,1));
		p44.setLayout(new GridLayout(10,4));
		
		p41.add(p42);
		p41.add(p43);
		p41.add(p44);
		
		p42.add(new JLabel("<html><span style='font-size:15px'>Datensatz einf�gen oder l�schen</span></html>"));
		p42.add(kktf1);
		p42.add(kktf2);
		p42.add(kkSende);
		p42.add(kkL�sche);
		
		p43.add(kkDatensatz);
		
		p44.add(new JLabel("<html><span style='font-size:15px'>Datensatz �ndern</span></html>"));
		p44.add(kkCb);
		p44.add(kktf3);
		p44.add(kktf4);
		p44.add(kk�ndern);
		p44.add(kkAktualisiere);
		
		tp.add("Kreditkarte", p41);	
						
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


	public JButton geta�ndern() {
		return a�ndern;
	}


	public void seta�ndern(JButton a�ndern) {
		this.a�ndern = a�ndern;
	}


	public JButton getaL�sche() {
		return aL�sche;
	}


	public void setaL�sche(JButton aL�sche) {
		this.aL�sche = aL�sche;
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


	public JButton getrL�sche() {
		return rL�sche;
	}


	public void setrL�sche(JButton rL�sche) {
		this.rL�sche = rL�sche;
	}


	public JButton getkL�sche() {
		return kL�sche;
	}


	public void setkL�sche(JButton kL�sche) {
		this.kL�sche = kL�sche;
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


	public JButton getGk�ndern() {
		return gk�ndern;
	}


	public void setGk�ndern(JButton gk�ndern) {
		this.gk�ndern = gk�ndern;
	}


	public JButton getGkL�sche() {
		return gkL�sche;
	}


	public void setGkL�sche(JButton gkL�sche) {
		this.gkL�sche = gkL�sche;
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


	public JButton getRp�ndern() {
		return rp�ndern;
	}


	public void setRp�ndern(JButton rp�ndern) {
		this.rp�ndern = rp�ndern;
	}


	public JButton getRpL�sche() {
		return rpL�sche;
	}


	public void setRpL�sche(JButton rpL�sche) {
		this.rpL�sche = rpL�sche;
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


	public JButton getLa�ndern() {
		return la�ndern;
	}


	public void setLa�ndern(JButton la�ndern) {
		this.la�ndern = la�ndern;
	}


	public JButton getLaL�sche() {
		return laL�sche;
	}


	public void setLaL�sche(JButton laL�sche) {
		this.laL�sche = laL�sche;
	}


	public JLabel getLaDatensatz() {
		return laDatensatz;
	}


	public void setLaDatensatz(JLabel laDatensatz) {
		this.laDatensatz = laDatensatz;
	}
	


	public JButton getk�ndern() {
		return k�ndern;
	}


	public void setk�ndern(JButton k�ndern) {
		this.k�ndern = k�ndern;
	}
	


	public JComboBox getKCb() {
		return kCb;
	}


	public void setkCb(JComboBox cb) {
		this.kCb = kCb;
	}
	
	


	public TextField getKtf6() {
		return ktf6;
	}


	public void setKtf6(TextField ktf6) {
		this.ktf6 = ktf6;
	}


	public TextField getKtf7() {
		return ktf7;
	}


	public void setKtf7(TextField ktf7) {
		this.ktf7 = ktf7;
	}


	public TextField getKtf8() {
		return ktf8;
	}


	public void setKtf8(TextField ktf8) {
		this.ktf8 = ktf8;
	}


	public TextField getKtf9() {
		return ktf9;
	}


	public void setKtf9(TextField ktf9) {
		this.ktf9 = ktf9;
	}


	public TextField getKtf10() {
		return ktf10;
	}


	public void setKtf10(TextField ktf10) {
		this.ktf10 = ktf10;
	}
	
	
	
	



	public JComboBox getGkCb() {
		return gkCb;
	}


	public void setGkCb(JComboBox gkCb) {
		this.gkCb = gkCb;
	}


	public JButton getr�ndern() {
		return r�ndern;
	}


	public void setr�ndern(JButton r�ndern) {
		this.r�ndern = r�ndern;
	}


	public JComboBox getrCb() {
		return rCb;
	}


	public void setrCb(JComboBox rCb) {
		this.rCb = rCb;
	}
	
	public JButton getkAktualisiere() {
		return kAktualisiere;
	}


	public void setkAktualisiere(JButton kAktualisiere) {
		this.kAktualisiere = kAktualisiere;
	}
	
	


	public JLabel getkDatensatz() {
		return kDatensatz;
	}


	public void setkDatensatz(JLabel kDatensatz) {
		this.kDatensatz = kDatensatz;
	}
	
	


	public JButton getrAktualisiere() {
		return rAktualisiere;
	}


	public void setrAktualisiere(JButton rAktualisiere) {
		this.rAktualisiere = rAktualisiere;
	}
	


	public JLabel getrDatensatz() {
		return rDatensatz;
	}


	public void setrDatensatz(JLabel rDatensatz) {
		this.rDatensatz = rDatensatz;
	}
	
	


	public JFrame getJf() {
		return jf;
	}


	public JTabbedPane getTp() {
		return tp;
	}


	public JPanel getP1() {
		return p1;
	}


	public JPanel getP2() {
		return p2;
	}


	public JPanel getP3() {
		return p3;
	}


	public JPanel getP4() {
		return p4;
	}


	public JPanel getP5() {
		return p5;
	}


	public JPanel getP6() {
		return p6;
	}


	public JPanel getP7() {
		return p7;
	}


	public JPanel getP8() {
		return p8;
	}


	public JPanel getP9() {
		return p9;
	}


	public JPanel getP10() {
		return p10;
	}


	public JPanel getP11() {
		return p11;
	}


	public JPanel getP12() {
		return p12;
	}


	public JPanel getP13() {
		return p13;
	}


	public JPanel getP14() {
		return p14;
	}


	public JPanel getP15() {
		return p15;
	}


	public JPanel getP16() {
		return p16;
	}


	public JPanel getP17() {
		return p17;
	}


	public JPanel getP18() {
		return p18;
	}


	public JPanel getP19() {
		return p19;
	}


	public JPanel getP20() {
		return p20;
	}


	public JPanel getP21() {
		return p21;
	}


	public JPanel getP22() {
		return p22;
	}


	public JPanel getP23() {
		return p23;
	}


	public JPanel getP24() {
		return p24;
	}


	public JPanel getP25() {
		return p25;
	}


	public JPanel getP26() {
		return p26;
	}


	public JPanel getP27() {
		return p27;
	}


	public JPanel getP28() {
		return p28;
	}


	public JPanel getP29() {
		return p29;
	}


	public JPanel getP30() {
		return p30;
	}


	public JPanel getP31() {
		return p31;
	}


	public JPanel getP32() {
		return p32;
	}


	public JPanel getP33() {
		return p33;
	}


	public JPanel getP34() {
		return p34;
	}


	public JPanel getP35() {
		return p35;
	}


	public JPanel getP36() {
		return p36;
	}


	public JPanel getP37() {
		return p37;
	}


	public JPanel getP38() {
		return p38;
	}


	public JPanel getP39() {
		return p39;
	}


	public JPanel getP40() {
		return p40;
	}


	public JPanel getP41() {
		return p41;
	}


	public JPanel getP42() {
		return p42;
	}


	public JPanel getP43() {
		return p43;
	}


	public JPanel getP44() {
		return p44;
	}


	public JComboBox getkCb() {
		return kCb;
	}


	public JComboBox getAnCb() {
		return anCb;
	}


	public JComboBox getArCb() {
		return arCb;
	}


	public JComboBox getLaCb() {
		return laCb;
	}


	public JComboBox getUfCb() {
		return ufCb;
	}


	public JComboBox getRpCb() {
		return rpCb;
	}


	public JComboBox getZaCb() {
		return zaCb;
	}


	public JComboBox getBeCb() {
		return beCb;
	}


	public JComboBox getKkCb() {
		return kkCb;
	}


	public TextField getAtf6() {
		return atf6;
	}


	public TextField getAtf7() {
		return atf7;
	}


	public TextField getAtf8() {
		return atf8;
	}


	public TextField getAtf9() {
		return atf9;
	}


	public TextField getAtf10() {
		return atf10;
	}


	public TextField getUftf1() {
		return uftf1;
	}


	public TextField getUftf2() {
		return uftf2;
	}


	public TextField getArtf1() {
		return artf1;
	}


	public TextField getArtf2() {
		return artf2;
	}


	public TextField getArtf3() {
		return artf3;
	}


	public TextField getArtf4() {
		return artf4;
	}


	public TextField getZatf1() {
		return zatf1;
	}


	public TextField getZatf2() {
		return zatf2;
	}


	public TextField getZatf3() {
		return zatf3;
	}


	public TextField getZatf4() {
		return zatf4;
	}


	public TextField getBetf1() {
		return betf1;
	}


	public TextField getBetf2() {
		return betf2;
	}


	public TextField getBetf3() {
		return betf3;
	}


	public TextField getBetf4() {
		return betf4;
	}


	public TextField getKktf1() {
		return kktf1;
	}


	public TextField getKktf2() {
		return kktf2;
	}


	public TextField getKktf3() {
		return kktf3;
	}


	public TextField getKktf4() {
		return kktf4;
	}


	public JButton getGkAktualisiere() {
		return gkAktualisiere;
	}


	public JButton getaAktualisiere() {
		return aAktualisiere;
	}


	public JButton getRpAktualisiere() {
		return rpAktualisiere;
	}


	public JButton getUfSende() {
		return ufSende;
	}


	public JButton getUf�ndern() {
		return uf�ndern;
	}


	public JButton getUfL�sche() {
		return ufL�sche;
	}


	public JButton getUfAktualisiere() {
		return ufAktualisiere;
	}


	public JButton getArSende() {
		return arSende;
	}


	public JButton getAr�ndern() {
		return ar�ndern;
	}


	public JButton getArL�sche() {
		return arL�sche;
	}


	public JButton getArAktualisiere() {
		return arAktualisiere;
	}


	public JButton getLaAktualisiere() {
		return laAktualisiere;
	}


	public JButton getZaSende() {
		return zaSende;
	}


	public JButton getZa�ndern() {
		return za�ndern;
	}


	public JButton getZaL�sche() {
		return zaL�sche;
	}


	public JButton getZaAktualisiere() {
		return zaAktualisiere;
	}


	public JButton getBeSende() {
		return beSende;
	}


	public JButton getBe�ndern() {
		return be�ndern;
	}


	public JButton getBeL�sche() {
		return beL�sche;
	}


	public JButton getBeAktualisiere() {
		return beAktualisiere;
	}


	public JButton getKkSende() {
		return kkSende;
	}


	public JButton getKk�ndern() {
		return kk�ndern;
	}


	public JButton getKkL�sche() {
		return kkL�sche;
	}


	public JButton getKkAktualisiere() {
		return kkAktualisiere;
	}


	public JLabel getUfDatensatz() {
		return ufDatensatz;
	}


	public JLabel getArDatensatz() {
		return arDatensatz;
	}


	public JLabel getZaDatensatz() {
		return zaDatensatz;
	}


	public JLabel getBeDatensatz() {
		return beDatensatz;
	}


	public JLabel getKkDatensatz() {
		return kkDatensatz;
	}


	public static void main(String[] args) throws SQLException{
		DB d=new DB();
		new testGUI(d);

	}
	

}

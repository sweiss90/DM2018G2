package test_Datenbank;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	private DB vb=null;
	
	private JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28,
		p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44;
		
	private TextField ktf1, ktf2, ktf3, ktf4, ktf5, ktf6, ktf7, ktf8, ktf9, ktf10;
	
	private JComboBox kCb, rCb, gkCb, anCb, arCb, laCb, ufCb, rpCb, zaCb, beCb, kkCb;
	
	private TextField rtf1, rtf2, rtf3, rtf4, rtf5, rtf6, rtf7, rtf8, rtf9, rtf10;
	
	private TextField gktf1, gktf2, gktf3, gktf4, gktf5, gktf6;
	
	private TextField atf1, atf2, atf3, atf4, atf5, atf6, atf7, atf8, atf9, atf10;
	
	private TextField rptf1, rptf2, rptf3, rptf4, rptf5, rptf6, rptf7, rptf8;
	
	private TextField uftf1, uftf2;
	
	private TextField artf1, artf2, artf3, artf4;
	
	private TextField latf1, latf2, latf3, latf4;
	
	private TextField zatf1, zatf2, zatf3, zatf4;
	
	private TextField betf1, betf2, betf3, betf4;
	
	private TextField kktf1, kktf2, kktf3, kktf4;
	
	private JButton kSende, kÄndern, kLösche, kAktualisiere, rSende, rÄndern, rLösche, rAktualisiere, gkSende, gkÄndern, gkLösche, gkAktualisiere,
			aSende, aÄndern, aLösche, aAktualisiere, rpSende, rpÄndern, rpLösche, rpAktualisiere, ufSende, ufÄndern, ufLösche, ufAktualisiere,
			arSende, arÄndern, arLösche, arAktualisiere, laSende, laÄndern, laLösche, laAktualisiere, zaSende, zaÄndern, zaLösche, zaAktualisiere,
			beSende, beÄndern, beLösche, beAktualisiere, kkSende, kkÄndern, kkLösche, kkAktualisiere;


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
	
	//Einfache Abfragen
	JTextField l11, l12, l13, l14, l15, l16, l162, l17, l18, l19, l21;
	JPanel p46, p47, p48, p49, p50, p51, p52, p53, p54, p55;
	JButton b11, b12, b13, b14, b15, b16, b17, b18, b19, b21;
	
	//Komplexe Abfragen
	JPanel p57, p58, p59, p60, p61, p62, p63, p64, p65, p66, p67, p68, p69, p70, p71;
	JTextField ka1, ka2, ka3, ka4, ka5, ka6, ka7, ka8, ka9, ka10, ka11, ka12, ka13, ka14, ka15, ka16, ka17, ka18, ka19, ka20, ka21, ka22, ka23,
			ka24, ka25, ka26, ka27, ka28, ka29, ka30, ka31, ka32, ka33, ka34, ka35, ka36, ka37;
	JButton k11, k12, k13, k14, k15, k16, k17, k18, k19, k20, k21, k22, k23, k24, k25, k26, k27;
	
	
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
		kLösche=new JButton("Löschen");
		kLösche.addActionListener(new EventHandlerButtons(this));
		kDatensatz=new JLabel("<Datensatz>");
		//kDatensatz.setSize(50, 700);
		kÄndern=new JButton("Ändern");
		kÄndern.addActionListener(new EventHandlerButtons(this));
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
		p2.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p2.add(ktf1);
		p2.add(ktf2);
		p2.add(ktf3);
		p2.add(ktf4);
		p2.add(ktf5);
		p2.add(kSende);
		p2.add(kLösche);
		
		p3.add(kDatensatz);
		
		p4.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p4.add(kCb);
		p4.add(ktf6);
		p4.add(ktf7);
		p4.add(ktf8);
		p4.add(ktf9);
		p4.add(ktf10);
		p4.add(kÄndern);
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
		rLösche=new JButton("Löschen");
		rLösche.addActionListener(new EventHandlerButtons(this));
		rDatensatz=new JLabel("<datensatz>");
		rÄndern=new JButton("Ändern");
		rÄndern.addActionListener(new EventHandlerButtons(this));
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
		
		p6.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p6.add(rtf1);
		p6.add(rtf2);
		p6.add(rtf3);
		p6.add(rtf4);
		p6.add(rtf5);
		p6.add(rSende);
		p6.add(rLösche);
		
		p7.add(rDatensatz);
			
		p8.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p8.add(rCb);
		p8.add(rtf6);
		p8.add(rtf7);
		p8.add(rtf8);
		p8.add(rtf9);
		p8.add(rtf10);
		p8.add(rÄndern);
		p8.add(rAktualisiere);
		
		tp.add("Rechnung", p5);
		
		//------------------------------------------------------
		//--------------Geschäftskunde
		vb.setSQL("SELECT * FROM geschäftskunde");
		GeschaeftskundenListe.getGeschaeftskundenListe().geschaeftskundenListeAktualisieren(vb);
		
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
		gkÄndern.addActionListener(new EventHandlerButtons(this));
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
		
		p10.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p10.add(gktf1);
		p10.add(gktf2);
		p10.add(gktf3);
		p10.add(gkSende);
		p10.add(gkLösche);
		
		p11.add(gkDatensatz);
	
		p12.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p12.add(gkCb);
		p12.add(gktf4);
		p12.add(gktf5);
		p12.add(gktf6);
		p12.add(gkÄndern);
		p12.add(gkAktualisiere);
		
		tp.add("Geschäftskunde", p9);
		
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
		aLösche=new JButton("Löschen");
		aLösche.addActionListener(new EventHandlerButtons(this));
		aDatensatz=new JLabel("<datensatz>");
		aÄndern=new JButton("Ändern");
		aÄndern.addActionListener(new EventHandlerButtons(this));
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
		
		p14.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p14.add(atf1);
		p14.add(atf2);
		p14.add(atf3);
		p14.add(atf4);
		p14.add(atf5);
		p14.add(aSende);
		p14.add(aLösche);
		
		p15.add(aDatensatz);
		
		p16.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p16.add(anCb);
		p16.add(atf6);
		p16.add(atf7);
		p16.add(atf8);
		p16.add(atf9);
		p16.add(atf10);
		p16.add(aÄndern);
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
		rpLösche=new JButton("Löschen");
		rpLösche.addActionListener(new EventHandlerButtons(this));
		rpDatensatz=new JLabel("<datensatz>");
		rpÄndern=new JButton("Ändern");
		rpÄndern.addActionListener(new EventHandlerButtons(this));
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
		
		p18.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p18.add(rptf1);
		p18.add(rptf2);
		p18.add(rptf3);
		p18.add(rptf4);
		p18.add(rpSende);
		p18.add(rpLösche);
		
		p19.add(rpDatensatz);
		
		p20.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p20.add(rpCb);
		p20.add(rptf5);
		p20.add(rptf6);
		p20.add(rptf7);
		p20.add(rptf8);
		p20.add(rpÄndern);
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
		ufLösche=new JButton("Löschen");
		ufLösche.addActionListener(new EventHandlerButtons(this));
		ufDatensatz=new JLabel("<datensatz>");
		ufÄndern=new JButton("Ändern");
		ufÄndern.addActionListener(new EventHandlerButtons(this));
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
		
		p22.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p22.add(uftf1);
		p22.add(ufSende);
		p22.add(ufLösche);
		
		p23.add(ufDatensatz);
		
		p24.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p24.add(ufCb);
		p24.add(uftf2);
		p24.add(ufÄndern);
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
		arLösche=new JButton("Löschen");
		arLösche.addActionListener(new EventHandlerButtons(this));
		arDatensatz=new JLabel("<datensatz>");
		arÄndern=new JButton("Ändern");
		arÄndern.addActionListener(new EventHandlerButtons(this));
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
		
		p26.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p26.add(artf1);
		p26.add(artf2);
		p26.add(arSende);
		p26.add(arLösche);
		
		p27.add(arDatensatz);
		
		p28.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p28.add(arCb);
		p28.add(artf3);
		p28.add(artf4);
		p28.add(arÄndern);
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
		laLösche=new JButton("Löschen");
		laLösche.addActionListener(new EventHandlerButtons(this));
		laDatensatz=new JLabel("<datensatz>");
		laÄndern=new JButton("Ändern");
		laÄndern.addActionListener(new EventHandlerButtons(this));
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
		
		p30.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p30.add(latf1);
		p30.add(latf2);
		p30.add(laSende);
		p30.add(laLösche);
		
		p31.add(laDatensatz);
		
		p32.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p32.add(laCb);
		p32.add(latf3);
		p32.add(latf4);
		p32.add(laÄndern);
		p32.add(laAktualisiere);
		
		tp.add("Land", p29);
		
		//----------------------------------------------------------------------------------------
		//------------------------------------- Zahlungsart---------------------------------------
		
		vb.setSQL("SELECT * FROM zahlungsart");// ->wird eigl nicht mehr benötigt
		ZahlungsartListe.getZahlungsartListe().zahlungsartListeAktualisieren(vb);

		p33=new JPanel();
		p34=new JPanel();
		p35=new JPanel();
		p36=new JPanel();
		
		zaSende=new JButton("Absenden");
		zaSende.addActionListener(new EventHandlerButtons(this));
		zaLösche=new JButton("Löschen");
		zaLösche.addActionListener(new EventHandlerButtons(this));
		zaDatensatz=new JLabel("<datensatz>");
		zaÄndern=new JButton("Ändern");
		zaÄndern.addActionListener(new EventHandlerButtons(this));
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
		
		p34.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p34.add(zatf1);
		p34.add(zatf2);
		p34.add(zaSende);
		p34.add(zaLösche);
		
		p35.add(zaDatensatz);
		
		p36.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p36.add(zaCb);
		p36.add(zatf3);
		p36.add(zatf4);
		p36.add(zaÄndern);
		p36.add(zaAktualisiere);
		
		tp.add("Zahlungsart", p33);
		
		//-----------------------------------------------------------------------------------------------
		//-------------------------------------Bankeinzug---------------------------------------
		vb.setSQL("SELECT * FROM bankeinzug");// ->wird eigl nicht mehr benötigt
		BankeinzugListe.getBankeinzugListe().bankeinzugListeAktualisieren(vb);

		p37=new JPanel();
		p38=new JPanel();
		p39=new JPanel();
		p40=new JPanel();
		
		beSende=new JButton("Absenden");
		beSende.addActionListener(new EventHandlerButtons(this));
		beLösche=new JButton("Löschen");
		beLösche.addActionListener(new EventHandlerButtons(this));
		beDatensatz=new JLabel("<datensatz>");
		beÄndern=new JButton("Ändern");
		beÄndern.addActionListener(new EventHandlerButtons(this));
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
		
		p38.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p38.add(betf1);
		p38.add(betf2);
		p38.add(beSende);
		p38.add(beLösche);
		
		p39.add(beDatensatz);
		
		p40.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p40.add(beCb);
		p40.add(betf3);
		p40.add(betf4);
		p40.add(beÄndern);
		p40.add(beAktualisiere);
		
		tp.add("Bankeinzug", p37);
				
	  //-----------------------------------------------------------------------------------------------
	  //------------------------------------Kreditkarte---------------------------------------
		vb.setSQL("SELECT * FROM kreditkarte");// ->wird eigl nicht mehr benötigt
		KreditkarteListe.getKreditkarteListe().kreditkarteListeAktualisieren(vb);

		p41=new JPanel();
		p42=new JPanel();
		p43=new JPanel();
		p44=new JPanel();
		
		kkSende=new JButton("Absenden");
		kkSende.addActionListener(new EventHandlerButtons(this));
		kkLösche=new JButton("Löschen");
		kkLösche.addActionListener(new EventHandlerButtons(this));
		kkDatensatz=new JLabel("<datensatz>");
		kkÄndern=new JButton("Ändern");
		kkÄndern.addActionListener(new EventHandlerButtons(this));
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
		
		p42.add(new JLabel("<html><span style='font-size:15px'>Datensatz einfügen oder löschen</span></html>"));
		p42.add(kktf1);
		p42.add(kktf2);
		p42.add(kkSende);
		p42.add(kkLösche);
		
		p43.add(kkDatensatz);
		
		p44.add(new JLabel("<html><span style='font-size:15px'>Datensatz ändern</span></html>"));
		p44.add(kkCb);
		p44.add(kktf3);
		p44.add(kktf4);
		p44.add(kkÄndern);
		p44.add(kkAktualisiere);
		
		tp.add("Kreditkarte", p41);	
						

		//--------------------------------------------------------------------------------------------------	
		//---------------------Einfache Abfragen-------------------------------------------------------------
		JPanel p45=new JPanel();
		
		p45.setLayout(new GridLayout(7, 3));
			p46=new JPanel();
			p46.setLayout(new FlowLayout());
			String n1="<HTML>1.) <font size=4>Gib alle Rechnungen aus der Liste aller Rechnungen, welche ___?___ wurden/sind.</font></HTML>";
			l11=new JTextField("(0/1)     ");
			b11=new JButton("Datensätze anzeigen");
			b11.addActionListener(new EventHandlerEinfacheAbfragen(this));
			p46.add(new JLabel(n1));
			p46.add(l11);
			p46.add(b11);
			p45.add(p46);
			
			p47=new JPanel();
			p47.setLayout(new FlowLayout());
			String n2="<HTML>2.) <font size=3>Gib alle Rechnungen aus der Liste aller Rechnungen, welche mindestens den Betrag ___?___ haben.</font></HTML>";
			l12=new JTextField("(Betrag)         ");
			b12=new JButton("Datensätze anzeigen");
			b12.addActionListener(new EventHandlerEinfacheAbfragen(this));
			p47.add(new JLabel(n2));
			p47.add(l12);
			p47.add(b12);
			p45.add(p47);
			
			p48=new JPanel();
			p48.setLayout(new FlowLayout());
			String n3="<HTML>3.) <font size=4>Gib alle Rechnungen aus der Liste aller Rechnungen, welche am  __?__  erstellt wurden.</font></HTML>";
			l13=new JTextField("(Datum)           ");
			b13=new JButton("Datensätze anzeigen");
			b13.addActionListener(new EventHandlerEinfacheAbfragen(this));
			p48.add(new JLabel(n3));
			p48.add(l13);
			p48.add(b13);
			p45.add(p48);
			
			p49=new JPanel();
			p49.setLayout(new FlowLayout());
			String n4="<HTML>4.) <font size=4>Gib alle Kunden mit dem Wohnort  ___?___</font></HTML>";
			l14=new JTextField("(Wohnort)         ");
			b14=new JButton("Datensätze anzeigen");
			b14.addActionListener(new EventHandlerEinfacheAbfragen(this));
			p49.add(new JLabel(n4));
			p49.add(l14);
			p49.add(b14);
			p45.add(p49);
			
			p50=new JPanel();
			p50.setLayout(new FlowLayout());
			String n5="<HTML>5.) <font size=4>Gib alle Privatkunden, die mindestens __?__ offene Rechnung(en) haben.</font></HTML>";
			l15=new JTextField("(offene Rechnungen)    ");
			b15=new JButton("Datensätze anzeigen");
			b15.addActionListener(new EventHandlerEinfacheAbfragen(this));
			p50.add(new JLabel(n5));
			p50.add(l15);
			p50.add(b15);
			p45.add(p50);
			
			
			//fehlt noch etwas
			p51=new JPanel();
			p51.setLayout(new FlowLayout());
			String n6="<HTML>6.) <font size=4>Gib alle Geschäftskunden, die __?__ __?__ Rechnung(en) haben</font></HTML>";
			l16=new JTextField("(Anzahl)  ");
			l162=new JTextField("(0/1)  ");
			b16=new JButton("Datensätze anzeigen");
			b16.addActionListener(new EventHandlerEinfacheAbfragen(this));
			p51.add(new JLabel(n6));
			p51.add(l16);
			p51.add(l162);
			p51.add(b16);
			p45.add(p51);
			
			p52=new JPanel();
			p52.setLayout(new FlowLayout());
			String n7="<HTML>7.) <font size=4>Gib alle Artikel mit einen Preis von mindestens __?__</font></HTML>";
			l17=new JTextField("(Mindestpreis)    ");
			b17=new JButton("Datensätze anzeigen");
			b17.addActionListener(new EventHandlerEinfacheAbfragen(this));
			p52.add(new JLabel(n7));
			p52.add(l17);
			p52.add(b17);
			p45.add(p52);
			
			p53=new JPanel();
			p53.setLayout(new FlowLayout());
			String n8="<HTML>8.) <font size=4>Gib alle Geschäftskunden, deren Unternehmensform eine __?__ ist.</font></HTML>";
			l18=new JTextField("(Rechtsform)      ");
			b18=new JButton("Datensätze anzeigen");
			b18.addActionListener(new EventHandlerEinfacheAbfragen(this));
			p53.add(new JLabel(n8));
			p53.add(l18);
			p53.add(b18);
			p45.add(p53);
			
			p54=new JPanel();
			p54.setLayout(new FlowLayout());
			String n9="<HTML>9.) <font size=4>Gib alle Privatkunden mit dem Vornamen __?__ aus.</font></HTML>";
			l19=new JTextField("(Vorname)        ");
			b19=new JButton("Datensätze anzeigen");
			b19.addActionListener(new EventHandlerEinfacheAbfragen(this));
			p54.add(new JLabel(n9));
			p54.add(l19);
			p54.add(b19);
			p45.add(p54);
			
			p55=new JPanel();
			p55.setLayout(new FlowLayout());
			String n10="<HTML>10.)<font size=4>Gib alle Geschäftskunden, deren Unternehmensform keine __?___ ist</font></HTML>";
			l21=new JTextField("(Rechtsform)      ");
			b21=new JButton("Datensätze anzeigen");
			b21.addActionListener(new EventHandlerEinfacheAbfragen(this));
			p55.add(new JLabel(n10));
			p55.add(l21);
			p55.add(b21);
			p45.add(p55);
			
		tp.add("Einfache Abfragen", p45);
		
		//-------------------------------------------------------------------------------------------------------
		//------------------Komplexe Abfragen-------------------------------------------------------------------
		JPanel p56=new JPanel();
		p56.setLayout(new FlowLayout());
		
		
		
		
		String k1="<HTML>1.)<font size=3>Gib alle Namen von Privatkunden sowie den Betrag von deren Rechnungen aus,"
				+ " bei denen das <br/> Land=___?___und Zahlungsart=Kreditkarte und mindestens __?__ unbezahlte Rechnungen haben. </font></HTML>";
		p57=new JPanel();
		p57.setLayout(new FlowLayout());
		ka1=new JTextField("(Land)    ");
		ka2=new JTextField("(Anzahl)  ");
		k11=new JButton("Datensätze anzeigen");
		k11.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p57.add(new JLabel(k1));
		p57.add(ka1);
		p57.add(ka2);
		p57.add(k11);
		p56.add(p57);
		
		String k2="<HTML>2.)<font size=3>Gib den Firmennamen sowie die Anschrift als auch den"
				+ " Ansprechpartner aller Geschäftskunden<br/> aus bei denen Land=__?__, Unternehmensform=__?__ "
				+ "und Kundenumsatz >1.000.000 GE ist. </font></HTML>";
		p58=new JPanel();
		p58.setLayout(new FlowLayout());
		ka3=new JTextField("(Land)    ");
		ka4=new JTextField("(Rechtsform)  ");
		k12=new JButton("Datensätze anzeigen");
		k12.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p58.add(new JLabel(k2));
		p58.add(ka3);
		p58.add(ka4);
		p58.add(k12);
		p56.add(p58);
		
		String k3="<HTML>3.)<font size=3>Gib von allen Rechnungspositionen den Einzel Artikelpreis aus, welche mindestens<br/> eine Menge"
				+ " von __?__ ME haben und deren dazugehörige Rechnung __?___ ist.</font></HTML>";
		p59=new JPanel();
		p59.setLayout(new FlowLayout());
		ka5=new JTextField("(Menge)    ");
		ka6=new JTextField("(Bezahlt/Unbezahlt)  ");
		k13=new JButton("Datensätze anzeigen");
		k13.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p59.add(new JLabel(k3));
		p59.add(ka5);
		p59.add(ka6);
		p59.add(k13);
		p56.add(p59);
		
		String k4="<HTML>4.)<font size=3>Gib den Betrag von allen Rechnungen sowie die dazugehörigen Firmennamen und "
				+ "Ansprechpartner als auch<br/> die dazugehörige E-Mail und Telefonnummer aller Geschäftskunden aus, "
				+ "die mehr als __?__ __?__ Rechnungen sowie deren<br/> Kunden Umsatz < __?__ GE als auch deren dazugehörige" 
                + "Unternehmensform ungleich __?__ oder __?__ ist. </font></HTML>";
		p60=new JPanel();
		p60.setLayout(new FlowLayout());
		ka7=new JTextField("(Menge)    ");
		ka8=new JTextField("(Bezahlt/Unbezahlt)  ");
		ka9=new JTextField("(Umsatz)    ");
		ka10=new JTextField("(Rechtsform1)  ");
		ka11=new JTextField("(Rechtsform2)    ");
		
		k14=new JButton("Datensätze anzeigen");
		k14.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p60.add(new JLabel(k4));
		p60.add(ka7);
		p60.add(ka8);
		p60.add(ka9);
		p60.add(ka10);
		p60.add(ka11);
		p60.add(k14);
		p56.add(p60);
		
		String k5="<HTML>5.)<font size=3>Gib alle Firmennamen sowie die dazugehörige Unternehmensform als auch die dazugehörige<br/> "
				+ "Anschrift von Geschäftskunden aus, welche einen Kundenumsatz >= __?__ GE sowie deren<br/> __?__ Rechnungen <2 als"
				+ " auch deren Land __?__ ist</font></HTML>";
		p61=new JPanel();
		p61.setLayout(new FlowLayout());
		ka12=new JTextField("(Umsatz)    ");
		ka13=new JTextField("(0/1)  ");
		ka14=new JTextField("(Land)    ");
	
		k15=new JButton("Datensätze anzeigen");
		k15.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p61.add(new JLabel(k5));
		p61.add(ka12);
		p61.add(ka13);
		p61.add(ka14);
		p61.add(k15);
		
		p56.add(p61);
		
		String k6="<HTML>6.)<font size=3>Gib alle Rechnungsnummern derjenigen Rechnungen aus, bei denen der Kunde den Ort ___?___ hat. </font></HTML>";
		p62=new JPanel();
		p62.setLayout(new FlowLayout());
		ka15=new JTextField("(Ort)     ");
	
		k16=new JButton("Datensätze anzeigen");
		k16.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p62.add(new JLabel(k6));
		p62.add(ka15);
		p62.add(k16);
		
		p56.add(p62);
		
		String k7="<HTML>7.)<font size=3>Gib alle Rechnungen aus deren Betrag zwischen"
				+ " __?__ GE und __?__ GE ist<br/> und die mindestens __?__ Rechnungspositionen mit einer"
				+ " Artikelmenge<br/> von jeweils >=__?__ ME haben. </font></HTML>";
		p63=new JPanel();
		p63.setLayout(new FlowLayout());
		ka16=new JTextField("(Untergrenze)     ");
		ka17=new JTextField("(Obergrenze)     ");
		ka18=new JTextField("(Anzahl)     ");
		ka19=new JTextField("(Menge)     ");
	
		k17=new JButton("Datensätze anzeigen");
		k17.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p63.add(new JLabel(k7));
		p63.add(ka16);
		p63.add(ka17);
		p63.add(ka18);
		p63.add(ka19);
		p63.add(k17);
		
		p56.add(p63);
		
		String k8="<HTML>8.)<font size=3> Gib alle Artikel aus, die in mehr als __?__ Rechnungspositionen vorkommen<br/>"
				+ " und deren dazugehörige Rechnungen bezahlt sind und einen Rechnungsbetrag von mindestens __?__ GE haben.</font></HTML>";
		p64=new JPanel();
		p64.setLayout(new FlowLayout());
		ka20=new JTextField("(Menge)     ");
		ka21=new JTextField("(Betrag)     ");
	
		k18=new JButton("Datensätze anzeigen");
		k18.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p64.add(new JLabel(k8));
		p64.add(ka20);
		p64.add(ka21);
		p64.add(k18);
		
		p56.add(p64);
		
		tp.add("Komplexe Abfragen", p56);
		
		String k9="<HTML>9.)<font size=3>Gib alle Artikel aus, die in mehr als<br/>"
				+ " __?__ Rechnungspositionen vorkommen und deren dazugehörige Rechnung<br/>"
				+ " zwischen dem __?__ und __?__ erstellt wurde. </font></HTML>";
		p65=new JPanel();
		p65.setLayout(new FlowLayout());
		ka22=new JTextField("(Menge)     ");
		ka23=new JTextField("(Datum)     ");
		ka24=new JTextField("(Datum)     ");
	
		k19=new JButton("Datensätze anzeigen");
		k19.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p65.add(new JLabel(k9));
		p65.add(ka22);
		p65.add(ka23);
		p65.add(ka24);
		p65.add(k19);
		
		p56.add(p65);
		
		String k10="<HTML>10.)<font size=3> Gib alle Rechnungen mit Zahlungsziel __?__ und<br/>"
				+ " deren dazugehöriger Geschäftskunde eine Anschrift in __?__ hat. </font></HTML>";
		p66=new JPanel();
		p66.setLayout(new FlowLayout());
		ka25=new JTextField("(Datum)     ");
		ka26=new JTextField("(Ort)     ");
	
		k20=new JButton("Datensätze anzeigen");
		k20.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p66.add(new JLabel(k10));
		p66.add(ka25);
		p66.add(ka26);
		p66.add(k20);
		
		p56.add(p66);
		
		tp.add("Komplexe Abfragen(1)", p56);
		
		
		//-------------neuer Tab-----------------------------------------------------
		JPanel jp57=new JPanel();
		String s1="<HTML>11.)<font size=3> Gib alle Kunden aus, deren Kundenumsatz größer"
				+ " als __?__ GE ist und deren Anschrift in ___?___ ist.</font></HTML>";
		p67=new JPanel();
		p67.setLayout(new FlowLayout());
		ka27=new JTextField("(Umsatz)     ");
		ka28=new JTextField("(Ort)     ");
	
		k21=new JButton("Datensätze anzeigen");
		k21.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p67.add(new JLabel(s1));
		p67.add(ka27);
		p67.add(ka28);
		p67.add(k21);
		
		jp57.add(p67);
		
		String s2="<HTML>12.)<font size=3> Gib alle Rechnungen mit einem Betrag größer gleich __?___"
				+ " GE ist und deren Empfänger ein Privatkunde mit dem Vornamen=__?__ und dem<br/>"
				+ " Nachnamen=___?__ ist. </font></HTML>";
		p68=new JPanel();
		p68.setLayout(new FlowLayout());
		ka29=new JTextField("(Umsatz)     ");
		ka30=new JTextField("(Vorname)     ");
		ka31=new JTextField("(Nachname)     ");
	
		k22=new JButton("Datensätze anzeigen");
		k22.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p68.add(new JLabel(s2));
		p68.add(ka29);
		p68.add(ka30);
		p68.add(ka31);
		p68.add(k22);
		
		jp57.add(p68);
		
		String s3="<HTML>13.)<font size=3>Gib alle Geschäftskunden mit der"
				+ " Unternehmensform = ___?___ und einem Kundenumsatz<br/>"
				+ " zwischen ___?__ und __?___ GE aus. </font></HTML>";
		p69=new JPanel();
		p69.setLayout(new FlowLayout());
		ka32=new JTextField("(Rechtsform)     ");
		ka33=new JTextField("(Umsatz)     ");
		ka34=new JTextField("(Umsatz)     ");
		
		k23=new JButton("Datensätze anzeigen");
		k23.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p69.add(new JLabel(s3));
		p69.add(ka32);
		p69.add(ka33);
		p69.add(ka34);
		p69.add(k23);
		
		jp57.add(p69);
		
		String s4="<HTML>14.)<font size=3> Gib die Rechnungen aller Kunden aus,"
				+ " deren Straße = ____?____ ist und deren<br/>"
				+ " Zahlungsart = ___?___ ist.</font></HTML>";
		p70=new JPanel();
		p70.setLayout(new FlowLayout());
		ka35=new JTextField("(Strasse)       ");
		ka36=new JTextField("(1/2/3)     ");
		
		k24=new JButton("Datensätze anzeigen");
		k24.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p70.add(new JLabel(s4));
		p70.add(ka35);
		p70.add(ka36);
		p70.add(k24);
		
		jp57.add(p70);
		
		String s5="<HTML>15.)<font size=3>Gib alle Privatkunden aus, deren Zahlungsart = Kreditkarte<br/>"
				+ " ist und die keine offenen Rechnungen haben und aus __?__ stammen. </font></HTML>";
		p71=new JPanel();
		p71.setLayout(new FlowLayout());
		ka37=new JTextField("(Land)         ");
		
		
		k25=new JButton("Datensätze anzeigen");
		k25.addActionListener(new EventHandlerKomplexeAbfragen(this));
		p71.add(new JLabel(s5));
		p71.add(ka37);
		p71.add(k25);
		
		jp57.add(p71);
		
		
		tp.add("Komplexe Abfragen(2)", jp57);

		
		jf.add(tp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		
	}
	

	public JTextField getL162() {
		return l162;
	}


	public void setL162(JTextField l162) {
		this.l162 = l162;
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
	


	public JButton getkÄndern() {
		return kÄndern;
	}


	public void setkÄndern(JButton kÄndern) {
		this.kÄndern = kÄndern;
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


	public JButton getrÄndern() {
		return rÄndern;
	}


	public void setrÄndern(JButton rÄndern) {
		this.rÄndern = rÄndern;
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


	public JButton getUfÄndern() {
		return ufÄndern;
	}


	public JButton getUfLösche() {
		return ufLösche;
	}


	public JButton getUfAktualisiere() {
		return ufAktualisiere;
	}


	public JButton getArSende() {
		return arSende;
	}


	public JButton getArÄndern() {
		return arÄndern;
	}


	public JButton getArLösche() {
		return arLösche;
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


	public JButton getZaÄndern() {
		return zaÄndern;
	}


	public JButton getZaLösche() {
		return zaLösche;
	}


	public JButton getZaAktualisiere() {
		return zaAktualisiere;
	}


	public JButton getBeSende() {
		return beSende;
	}


	public JButton getBeÄndern() {
		return beÄndern;
	}


	public JButton getBeLösche() {
		return beLösche;
	}


	public JButton getBeAktualisiere() {
		return beAktualisiere;
	}


	public JButton getKkSende() {
		return kkSende;
	}


	public JButton getKkÄndern() {
		return kkÄndern;
	}


	public JButton getKkLösche() {
		return kkLösche;
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
	
	public JButton getB11() {
		return b11;
	}
	
	public void setB11(JButton b11) {
		this.b11 = b11;
	}


	public JButton getB12() {
		return b12;
	}


	public void setB12(JButton b12) {
		this.b12 = b12;
	}


	public JButton getB13() {
		return b13;
	}


	public void setB13(JButton b13) {
		this.b13 = b13;
	}


	public JButton getB14() {
		return b14;
	}


	public void setB14(JButton b14) {
		this.b14 = b14;
	}


	public JButton getB15() {
		return b15;
	}


	public void setB15(JButton b15) {
		this.b15 = b15;
	}


	public JButton getB16() {
		return b16;
	}


	public void setB16(JButton b16) {
		this.b16 = b16;
	}


	public JButton getB17() {
		return b17;
	}


	public void setB17(JButton b17) {
		this.b17 = b17;
	}


	public JButton getB18() {
		return b18;
	}


	public void setB18(JButton b18) {
		this.b18 = b18;
	}


	public JButton getB19() {
		return b19;
	}


	public void setB19(JButton b19) {
		this.b19 = b19;
	}


	public JButton getB21() {
		return b21;
	}


	public void setB21(JButton b21) {
		this.b21 = b21;
	}
	


	public JTextField getL11() {
		return l11;
	}


	public void setL11(JTextField l11) {
		this.l11 = l11;
	}


	public JTextField getL12() {
		return l12;
	}


	public void setL12(JTextField l12) {
		this.l12 = l12;
	}


	public JTextField getL13() {
		return l13;
	}


	public void setL13(JTextField l13) {
		this.l13 = l13;
	}


	public JTextField getL14() {
		return l14;
	}


	public void setL14(JTextField l14) {
		this.l14 = l14;
	}


	public JTextField getL15() {
		return l15;
	}


	public void setL15(JTextField l15) {
		this.l15 = l15;
	}


	public JTextField getL16() {
		return l16;
	}


	public void setL16(JTextField l16) {
		this.l16 = l16;
	}


	public JTextField getL17() {
		return l17;
	}


	public void setL17(JTextField l17) {
		this.l17 = l17;
	}


	public JTextField getL18() {
		return l18;
	}


	public void setL18(JTextField l18) {
		this.l18 = l18;
	}


	public JTextField getL19() {
		return l19;
	}


	public void setL19(JTextField l19) {
		this.l19 = l19;
	}


	public JTextField getL21() {
		return l21;
	}


	public void setL21(JTextField l21) {
		this.l21 = l21;
	}
	
	
	
	


	public JButton getK11() {
		return k11;
	}


	public void setK11(JButton k11) {
		this.k11 = k11;
	}


	public JButton getK12() {
		return k12;
	}


	public void setK12(JButton k12) {
		this.k12 = k12;
	}


	public JButton getK13() {
		return k13;
	}


	public void setK13(JButton k13) {
		this.k13 = k13;
	}


	public JButton getK14() {
		return k14;
	}


	public void setK14(JButton k14) {
		this.k14 = k14;
	}


	public JButton getK15() {
		return k15;
	}


	public void setK15(JButton k15) {
		this.k15 = k15;
	}


	public JButton getK16() {
		return k16;
	}


	public void setK16(JButton k16) {
		this.k16 = k16;
	}


	public JButton getK17() {
		return k17;
	}


	public void setK17(JButton k17) {
		this.k17 = k17;
	}


	public JButton getK18() {
		return k18;
	}


	public void setK18(JButton k18) {
		this.k18 = k18;
	}


	public JButton getK19() {
		return k19;
	}


	public void setK19(JButton k19) {
		this.k19 = k19;
	}


	public JButton getK20() {
		return k20;
	}


	public void setK20(JButton k20) {
		this.k20 = k20;
	}


	public JButton getK21() {
		return k21;
	}


	public void setK21(JButton k21) {
		this.k21 = k21;
	}


	public JButton getK22() {
		return k22;
	}


	public void setK22(JButton k22) {
		this.k22 = k22;
	}


	public JButton getK23() {
		return k23;
	}


	public void setK23(JButton k23) {
		this.k23 = k23;
	}


	public JButton getK24() {
		return k24;
	}


	public void setK24(JButton k24) {
		this.k24 = k24;
	}


	public JButton getK25() {
		return k25;
	}


	public void setK25(JButton k25) {
		this.k25 = k25;
	}


	public JButton getK26() {
		return k26;
	}


	public void setK26(JButton k26) {
		this.k26 = k26;
	}


	public JButton getK27() {
		return k27;
	}


	public void setK27(JButton k27) {
		this.k27 = k27;
	}
	
	


	public JTextField getKa3() {
		return ka3;
	}


	public void setKa3(JTextField ka3) {
		this.ka3 = ka3;
	}


	public JTextField getKa5() {
		return ka5;
	}


	public void setKa5(JTextField ka5) {
		this.ka5 = ka5;
	}


	public JTextField getKa6() {
		return ka6;
	}


	public void setKa6(JTextField ka6) {
		this.ka6 = ka6;
	}


	public JTextField getKa7() {
		return ka7;
	}


	public void setKa7(JTextField ka7) {
		this.ka7 = ka7;
	}


	public JTextField getKa8() {
		return ka8;
	}


	public void setKa8(JTextField ka8) {
		this.ka8 = ka8;
	}


	public JTextField getKa9() {
		return ka9;
	}


	public void setKa9(JTextField ka9) {
		this.ka9 = ka9;
	}


	public JTextField getKa1() {
		return ka1;
	}


	public void setKa1(JTextField ka1) {
		this.ka1 = ka1;
	}


	public JTextField getKa2() {
		return ka2;
	}


	public void setKa2(JTextField ka2) {
		this.ka2 = ka2;
	}


	public JTextField getKa4() {
		return ka4;
	}


	public void setKa4(JTextField ka4) {
		this.ka4 = ka4;
	}


	public JTextField getKa10() {
		return ka10;
	}


	public void setKa10(JTextField ka10) {
		this.ka10 = ka10;
	}


	public JTextField getKa11() {
		return ka11;
	}


	public void setKa11(JTextField ka11) {
		this.ka11 = ka11;
	}


	public JTextField getKa12() {
		return ka12;
	}


	public void setKa12(JTextField ka12) {
		this.ka12 = ka12;
	}


	public JTextField getKa13() {
		return ka13;
	}


	public void setKa13(JTextField ka13) {
		this.ka13 = ka13;
	}


	public JTextField getKa14() {
		return ka14;
	}


	public void setKa14(JTextField ka14) {
		this.ka14 = ka14;
	}


	public JTextField getKa15() {
		return ka15;
	}


	public void setKa15(JTextField ka15) {
		this.ka15 = ka15;
	}


	public JTextField getKa16() {
		return ka16;
	}


	public void setKa16(JTextField ka16) {
		this.ka16 = ka16;
	}


	public JTextField getKa17() {
		return ka17;
	}


	public void setKa17(JTextField ka17) {
		this.ka17 = ka17;
	}


	public JTextField getKa18() {
		return ka18;
	}


	public void setKa18(JTextField ka18) {
		this.ka18 = ka18;
	}


	public JTextField getKa19() {
		return ka19;
	}


	public void setKa19(JTextField ka19) {
		this.ka19 = ka19;
	}


	public JTextField getKa20() {
		return ka20;
	}


	public void setKa20(JTextField ka20) {
		this.ka20 = ka20;
	}


	public JTextField getKa21() {
		return ka21;
	}


	public void setKa21(JTextField ka21) {
		this.ka21 = ka21;
	}


	public JTextField getKa22() {
		return ka22;
	}


	public void setKa22(JTextField ka22) {
		this.ka22 = ka22;
	}


	public JTextField getKa23() {
		return ka23;
	}


	public void setKa23(JTextField ka23) {
		this.ka23 = ka23;
	}


	public JTextField getKa24() {
		return ka24;
	}


	public void setKa24(JTextField ka24) {
		this.ka24 = ka24;
	}


	public JTextField getKa25() {
		return ka25;
	}


	public void setKa25(JTextField ka25) {
		this.ka25 = ka25;
	}


	public JTextField getKa26() {
		return ka26;
	}


	public void setKa26(JTextField ka26) {
		this.ka26 = ka26;
	}


	public JTextField getKa27() {
		return ka27;
	}


	public void setKa27(JTextField ka27) {
		this.ka27 = ka27;
	}


	public JTextField getKa28() {
		return ka28;
	}


	public void setKa28(JTextField ka28) {
		this.ka28 = ka28;
	}


	public JTextField getKa29() {
		return ka29;
	}


	public void setKa29(JTextField ka29) {
		this.ka29 = ka29;
	}


	public JTextField getKa30() {
		return ka30;
	}


	public void setKa30(JTextField ka30) {
		this.ka30 = ka30;
	}


	public JTextField getKa31() {
		return ka31;
	}


	public void setKa31(JTextField ka31) {
		this.ka31 = ka31;
	}


	public JTextField getKa32() {
		return ka32;
	}


	public void setKa32(JTextField ka32) {
		this.ka32 = ka32;
	}


	public JTextField getKa33() {
		return ka33;
	}


	public void setKa33(JTextField ka33) {
		this.ka33 = ka33;
	}


	public JTextField getKa34() {
		return ka34;
	}


	public void setKa34(JTextField ka34) {
		this.ka34 = ka34;
	}


	public JTextField getKa35() {
		return ka35;
	}


	public void setKa35(JTextField ka35) {
		this.ka35 = ka35;
	}


	public JTextField getKa36() {
		return ka36;
	}


	public void setKa36(JTextField ka36) {
		this.ka36 = ka36;
	}


	public JTextField getKa37() {
		return ka37;
	}


	public void setKa37(JTextField ka37) {
		this.ka37 = ka37;
	}


	public static void main(String[] args) throws SQLException{
		DB d=new DB();
		new testGUI(d);

	}
	

}



import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;






public class Interface extends JPanel implements ActionListener, KeyListener,MouseListener {


	private CE203_fh17602_assignment2.Instance state;
	private Timer timer;
	private int timerDelay = 22;

	private int shiprespawndlay = 50;

	private static int score = 0;
	private static int Strandsinfected = 0;
	public void Input(){
	}

//Create the application
	public Interface() {
		addMouseListener(this);

		addKeyListener(this);
		this.setFocusable(true);
		CE203_fh17602_assignment2.Context.user = new CE203_fh17602_assignment2.User();
		CE203_fh17602_assignment2.Manager.instantstrand ();
		CE203_fh17602_assignment2.Context.shots = new ArrayList<CE203_fh17602_assignment2.Shots>();
		CE203_fh17602_assignment2.Context.covidshots = new ArrayList<CE203_fh17602_assignment2.covidshots>();

		CE203_fh17602_assignment2.Context.Alst = new CE203_fh17602_assignment2.MultiArraylst();

		state = CE203_fh17602_assignment2.Instance.Menu;

		//init timer
		timer = new Timer(timerDelay, this);
		timer.start();


		CE203_fh17602_assignment2.Context.masks = new CE203_fh17602_assignment2.Mask[]{
				//left Facemask
				//one square is 36x36 px
				new CE203_fh17602_assignment2.Mask(60, 616, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(180, 616, CE203_fh17602_assignment2.Mask.shape.SQUARE), //bottomsquares
				new CE203_fh17602_assignment2.Mask(60, 580, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(180, 580, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(180, 544, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(180, 508, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(60, 544, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(60, 508, CE203_fh17602_assignment2.Mask.shape.SQUARE),
				new CE203_fh17602_assignment2.Mask(144, 508, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(144, 544, CE203_fh17602_assignment2.Mask.shape.BSQUARE), new CE203_fh17602_assignment2.Mask(96, 508, CE203_fh17602_assignment2.Mask.shape.BSQUARE),	new CE203_fh17602_assignment2.Mask(96, 544, CE203_fh17602_assignment2.Mask.shape.BSQUARE), new CE203_fh17602_assignment2.Mask(96, 472, CE203_fh17602_assignment2.Mask.shape.BSQUARE),	new CE203_fh17602_assignment2.Mask(144, 472, CE203_fh17602_assignment2.Mask.shape.BSQUARE), new CE203_fh17602_assignment2.Mask(96, 452, CE203_fh17602_assignment2.Mask.shape.BSQUARE),	new CE203_fh17602_assignment2.Mask(144, 452, CE203_fh17602_assignment2.Mask.shape.BSQUARE),
				new CE203_fh17602_assignment2.Mask(120, 508, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(120, 544, CE203_fh17602_assignment2.Mask.shape.BSQUARE),//middle blue square
				new CE203_fh17602_assignment2.Mask(120, 472, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(120, 472, CE203_fh17602_assignment2.Mask.shape.BSQUARE), new CE203_fh17602_assignment2.Mask(120, 452, CE203_fh17602_assignment2.Mask.shape.BSQUARE),
				new CE203_fh17602_assignment2.Mask(70, 480, CE203_fh17602_assignment2.Mask.shape.arc),new CE203_fh17602_assignment2.Mask(180, 480, CE203_fh17602_assignment2.Mask.shape.Arc1),

				//Facemask 2
				new CE203_fh17602_assignment2.Mask(300, 616, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(420, 616, CE203_fh17602_assignment2.Mask.shape.SQUARE), //bottomsquares
				new CE203_fh17602_assignment2.Mask(300, 580, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(420, 580, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(420, 544, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(420, 508, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(300, 544, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(300, 508, CE203_fh17602_assignment2.Mask.shape.SQUARE),
				new CE203_fh17602_assignment2.Mask(386, 508, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(386, 544, CE203_fh17602_assignment2.Mask.shape.BSQUARE), new CE203_fh17602_assignment2.Mask(336, 508, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(336, 544, CE203_fh17602_assignment2.Mask.shape.BSQUARE), new CE203_fh17602_assignment2.Mask(336, 472, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(386, 472, CE203_fh17602_assignment2.Mask.shape.BSQUARE), new CE203_fh17602_assignment2.Mask(336, 452, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(386, 452, CE203_fh17602_assignment2.Mask.shape.BSQUARE),
				new CE203_fh17602_assignment2.Mask(361, 508, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(361, 544, CE203_fh17602_assignment2.Mask.shape.BSQUARE),//middle blue square
				new CE203_fh17602_assignment2.Mask(361, 472, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(361, 472, CE203_fh17602_assignment2.Mask.shape.BSQUARE), new CE203_fh17602_assignment2.Mask(361, 452, CE203_fh17602_assignment2.Mask.shape.BSQUARE),
				new CE203_fh17602_assignment2.Mask(310, 480, CE203_fh17602_assignment2.Mask.shape.arc),new CE203_fh17602_assignment2.Mask(420, 480, CE203_fh17602_assignment2.Mask.shape.Arc1),


				//Facemask3
				new CE203_fh17602_assignment2.Mask(540, 616, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(660, 616, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(540, 580, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(660, 580, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(660, 544, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(660, 508, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(540, 544, CE203_fh17602_assignment2.Mask.shape.SQUARE), new CE203_fh17602_assignment2.Mask(540, 508, CE203_fh17602_assignment2.Mask.shape.SQUARE),
				new CE203_fh17602_assignment2.Mask(626, 508, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(626, 544, CE203_fh17602_assignment2.Mask.shape.BSQUARE), new CE203_fh17602_assignment2.Mask(576, 508, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(576, 544, CE203_fh17602_assignment2.Mask.shape.BSQUARE), new CE203_fh17602_assignment2.Mask(576, 472, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(626, 472, CE203_fh17602_assignment2.Mask.shape.BSQUARE), new CE203_fh17602_assignment2.Mask(576, 452, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(626, 452, CE203_fh17602_assignment2.Mask.shape.BSQUARE),
				new CE203_fh17602_assignment2.Mask(601, 508, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(601, 544, CE203_fh17602_assignment2.Mask.shape.BSQUARE),//middle blue square
				new CE203_fh17602_assignment2.Mask(601, 472, CE203_fh17602_assignment2.Mask.shape.BSQUARE),new CE203_fh17602_assignment2.Mask(601, 472, CE203_fh17602_assignment2.Mask.shape.BSQUARE), new CE203_fh17602_assignment2.Mask(601, 452, CE203_fh17602_assignment2.Mask.shape.BSQUARE),
				new CE203_fh17602_assignment2.Mask(550, 480, CE203_fh17602_assignment2.Mask.shape.arc),new CE203_fh17602_assignment2.Mask(660, 480, CE203_fh17602_assignment2.Mask.shape.Arc1),
		};


	}

	@Override
	protected void paintComponent(Graphics CI) {
		super.paintComponent(CI);

		repaint(); revalidate();

		//Creating Star background, game can also be played in plain black background

		CI.setColor(Color.BLACK);
		CI.fillRect (0,0, CE203_fh17602_assignment2.Context.windowWidth, CE203_fh17602_assignment2.Context.windowHeight);
		CI.setColor (Color.WHITE);
		for (int i= 0;i<10;i++) { // increase the value of i to increase stars in background
			CI.fillOval ((int) (Math.random () * CE203_fh17602_assignment2.Context.windowWidth), (int) (Math.random () * CE203_fh17602_assignment2.Context.windowHeight), 2, 2);
		}
		//CI.fillRect(0, 0, Context.windowWidth, Context.windowHeight);

		if(state == CE203_fh17602_assignment2.Instance.Play) {
			graphicRunning(CI);
		}
		else if(state == CE203_fh17602_assignment2.Instance.Menu) {
			Mainmenuscreen (CI);
		}
		else if(state == CE203_fh17602_assignment2.Instance.Missionfailed) {
			Missionfailedscreen (CI);
		}
		else if(state == CE203_fh17602_assignment2.Instance.top5scores) {
			top5scorescreen(CI);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (state == CE203_fh17602_assignment2.Instance.Play) {
			switch (e.getID ()) {
				case MouseEvent.MOUSE_CLICKED:
					e:
					if (CE203_fh17602_assignment2.Manager.gtusertime () > CE203_fh17602_assignment2.Context.user.timebetweeneachshot) {
						CE203_fh17602_assignment2.Context.shots.add (new CE203_fh17602_assignment2.Shots(CE203_fh17602_assignment2.Context.user.gtHorizontalplace () + 26, CE203_fh17602_assignment2.Context.user.gttVerticalplace ()-22, -11));
						CE203_fh17602_assignment2.Manager.rstusertime ();


					}
			}
		}

	}

	public static void addScore(int value) {score+=value;}

	@Override
	public void keyPressed(KeyEvent mve) {

		if(state == CE203_fh17602_assignment2.Instance.Play) {
			if(!CE203_fh17602_assignment2.Context.user.exterminateed ()) {
				switch (mve.getKeyCode()) {

					case KeyEvent.VK_LEFT:
					if(CE203_fh17602_assignment2.Context.user.gtHorizontalplace ()>10) CE203_fh17602_assignment2.Context.user.move(-8);// keeping the user inside the specified screen
					break;

				case KeyEvent.VK_RIGHT:
					if(CE203_fh17602_assignment2.Context.user.gtHorizontalplace ()<730) CE203_fh17602_assignment2.Context.user.move(8); // keeping the user inside the specified screen
					break;

				case KeyEvent.VK_SPACE:
					if(CE203_fh17602_assignment2.Manager.gtusertime () > CE203_fh17602_assignment2.Context.user.timebetweeneachshot) {
						CE203_fh17602_assignment2.Context.shots.add(new CE203_fh17602_assignment2.Shots(CE203_fh17602_assignment2.Context.user.gtHorizontalplace ()+26, CE203_fh17602_assignment2.Context.user.gttVerticalplace ()-22, -11));

						CE203_fh17602_assignment2.Manager.rstusertime ();
					}
					break;
				}
			}
		}
		else if(state == CE203_fh17602_assignment2.Instance.Menu) {
			switch(mve.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				state = CE203_fh17602_assignment2.Instance.Play;
				break;

				case KeyEvent.VK_H:
				state = CE203_fh17602_assignment2.Instance.top5scores;
				break;
			}
		}
		else if(state == CE203_fh17602_assignment2.Instance.Missionfailed) {
			state = CE203_fh17602_assignment2.Instance.Menu;

			if(score > CE203_fh17602_assignment2.Context.top5scores[4]) {
				CE203_fh17602_assignment2.Context.top5scores[4] = score;
				CE203_fh17602_assignment2.Manager.scorefromtoptobottom ();
				CE203_fh17602_assignment2.Loadfiles.crthhghsres();
			}

			score = 0;
			CE203_fh17602_assignment2.Manager.reinstantize ();
		}
		else if(state == CE203_fh17602_assignment2.Instance.top5scores) {
			state = CE203_fh17602_assignment2.Instance.Menu;
		}
	}


	@Override
	public void actionPerformed(ActionEvent mve) {

		if(state == CE203_fh17602_assignment2.Instance.Play) {
			if(!CE203_fh17602_assignment2.Context.user.exterminateed ()) {
				//calling methods
				CE203_fh17602_assignment2.Manager.changeDelays ();
				CE203_fh17602_assignment2.Manager.strandmovement ();
				CE203_fh17602_assignment2.Manager.bottomstrandshoot ();
				CE203_fh17602_assignment2.Manager.mveshots ();
				CE203_fh17602_assignment2.Manager.shothittingfacemask ();
				CE203_fh17602_assignment2.Manager.mvecovidpjs ();
				CE203_fh17602_assignment2.Manager.covidshothittingfacemask ();


				if (CE203_fh17602_assignment2.Manager.injectionhitvirus ()) {
					Strandsinfected++;
				}

				if (CE203_fh17602_assignment2.Manager.shothittingplayer ()) {
					System.out.println ("You have been infected! Respawning");
					CE203_fh17602_assignment2.Context.user.setExtermnated (true);
				}

				if (CE203_fh17602_assignment2.Manager.collisionwithstrandsandmasks ())
					state = CE203_fh17602_assignment2.Instance.Missionfailed;


			}

			if(CE203_fh17602_assignment2.Context.user.exterminateed ()) {
				shiprespawndlay--;
				if(shiprespawndlay == 0) {
					shiprespawndlay = 50;
					if(CE203_fh17602_assignment2.Context.user.Hlth ()>0)//if health is greater than 0 then continue the game otherwise show the mission failed screen
						CE203_fh17602_assignment2.Context.user.setExtermnated (false);
					else
						state = CE203_fh17602_assignment2.Instance.Missionfailed;

					System.out.println("");
				}
			}

			if(Strandsinfected == CE203_fh17602_assignment2.Context.lineofstrand * CE203_fh17602_assignment2.Context.rowsofstrand) {
				Strandsinfected = 0;
				CE203_fh17602_assignment2.Manager.instantstrand ();
				CE203_fh17602_assignment2.Covid.LowerGamespeed ();
				CE203_fh17602_assignment2.Context.user.gainhealth ();
				//if user has injected all the strands that are visible give user a life
			}
		}

		repaint(); revalidate();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

				}


	@Override
	public void keyTyped(KeyEvent arg0) {}




	private static void graphicRunning(Graphics CI) {
		if(!CE203_fh17602_assignment2.Context.user.exterminateed () ) {
			CI.drawImage(CE203_fh17602_assignment2.Loadfiles.MEDICALSHIP, CE203_fh17602_assignment2.Context.user.gtHorizontalplace (), CE203_fh17602_assignment2.Context.user.gttVerticalplace (), CE203_fh17602_assignment2.Loadfiles.MEDICALSHIP.getWidth()+25, CE203_fh17602_assignment2.Loadfiles.MEDICALSHIP.getHeight()+7, null);
		}
		else {
			CI.drawImage(CE203_fh17602_assignment2.Loadfiles.explosionspirte, CE203_fh17602_assignment2.Context.user.gtHorizontalplace (), CE203_fh17602_assignment2.Context.user.gttVerticalplace (), CE203_fh17602_assignment2.Loadfiles.explosionspirte.getWidth()+25, CE203_fh17602_assignment2.Loadfiles.explosionspirte.getHeight()+15, null);
		}

		//base line to add score and lives icons
		CI.setColor(Color.RED);
		CI.fillRect(5, 720, 800, 5);

		CI.setColor(Color.LIGHT_GRAY);
		CI.setFont (new Font(Font.DIALOG_INPUT,  Font.BOLD, 24));
		CI.drawString("Score: "+score, 600, 750);
		CI.drawString("Health: ", 4, 750);

		//Health
		for(int i = 0; i< CE203_fh17602_assignment2.Context.user.Hlth (); i++) {
			CI.drawImage(CE203_fh17602_assignment2.Loadfiles.Health, i*42+108, 731, CE203_fh17602_assignment2.Loadfiles.Health.getWidth()+20, CE203_fh17602_assignment2.Loadfiles.Health.getHeight()+15, null);
		}



		//load injections and draw them
		for(int i = 0; i< CE203_fh17602_assignment2.Context.shots.size(); i++) {
			CI.drawImage (CE203_fh17602_assignment2.Loadfiles.injection, CE203_fh17602_assignment2.Context.shots.get (i).gtHorizontalplace (), CE203_fh17602_assignment2.Context.shots.get (i).gttVerticalplace (), CE203_fh17602_assignment2.Loadfiles.injection.getWidth (), CE203_fh17602_assignment2.Loadfiles.injection.getHeight () + 20, null);
		}
		//draw the covidshots
		CI.setColor(Color.PINK);
		for(int i = 0; i< CE203_fh17602_assignment2.Context.covidshots.size(); i++) {

			CI.fillRect (CE203_fh17602_assignment2.Context.covidshots.get (i).gtHorizontalplace (), CE203_fh17602_assignment2.Context.covidshots.get (i).gttVerticalplace (), 3, 12);
		}






//load the covid strand sprites and draw them
		CE203_fh17602_assignment2.Context.Alst.draw((Graphics2D) CI);
		for(int i = 0; i< CE203_fh17602_assignment2.Context.masks.length; i++) {
			if(CE203_fh17602_assignment2.Context.masks[i].whchshpe () == CE203_fh17602_assignment2.Mask.shape.arc) {
				switch(CE203_fh17602_assignment2.Context.masks[i].dmg ()) {
					case 1:
						CI.drawImage(CE203_fh17602_assignment2.Loadfiles.arc, CE203_fh17602_assignment2.Context.masks[i].gtHorizontalplace (), CE203_fh17602_assignment2.Context.masks[i].gttVerticalplace (), CE203_fh17602_assignment2.Loadfiles.arc.getWidth()*2, CE203_fh17602_assignment2.Loadfiles.arc.getHeight()*2, null); break;
							//loading the images and defining the parameters for them
					default:
						continue;
				}
			}

			if(CE203_fh17602_assignment2.Context.masks[i].whchshpe () == CE203_fh17602_assignment2.Mask.shape.Arc1) {
				if (CE203_fh17602_assignment2.Context.masks[i].dmg () == 1) {
					CI.drawImage (CE203_fh17602_assignment2.Loadfiles.arcc, CE203_fh17602_assignment2.Context.masks[i].gtHorizontalplace (), CE203_fh17602_assignment2.Context.masks[i].gttVerticalplace (), CE203_fh17602_assignment2.Loadfiles.arcc.getWidth () * 2, CE203_fh17602_assignment2.Loadfiles.arcc.getHeight () * 2, null);
				} else {
					continue;
				}
			}
			if(CE203_fh17602_assignment2.Context.masks[i].whchshpe () == CE203_fh17602_assignment2.Mask.shape.SQUARE) {
				if (CE203_fh17602_assignment2.Context.masks[i].dmg () == 1) {
					CI.drawImage (CE203_fh17602_assignment2.Loadfiles.WHITEMASKSQUAREE, CE203_fh17602_assignment2.Context.masks[i].gtHorizontalplace (), CE203_fh17602_assignment2.Context.masks[i].gttVerticalplace (), CE203_fh17602_assignment2.Loadfiles.WHITEMASKSQUAREE.getWidth () + 24, CE203_fh17602_assignment2.Loadfiles.WHITEMASKSQUAREE.getHeight () + 24, null);
				} else {
					continue;
				}
			}

			if(CE203_fh17602_assignment2.Context.masks[i].whchshpe () == CE203_fh17602_assignment2.Mask.shape.BSQUARE) {
				if (CE203_fh17602_assignment2.Context.masks[i].dmg () == 1) {
					CI.drawImage (CE203_fh17602_assignment2.Loadfiles.BLUEBASKSQUARE, CE203_fh17602_assignment2.Context.masks[i].gtHorizontalplace (), CE203_fh17602_assignment2.Context.masks[i].gttVerticalplace (), CE203_fh17602_assignment2.Loadfiles.BLUEBASKSQUARE.getWidth () * 3, CE203_fh17602_assignment2.Loadfiles.BLUEBASKSQUARE.getHeight () * 3, null);
				} else {
					continue;
				}
			}


		}
	}

	private static void Mainmenuscreen(Graphics CI) {
		Graphics2D g2d=(Graphics2D)CI;
		//Draw the main menu title
		CI.setColor(Color.red);
		CI.setFont (new Font(Font.DIALOG_INPUT,  Font.BOLD, 70));
		CI.drawString("Covid-19", 92, 80);

		CI.setColor(Color.LIGHT_GRAY);
		CI.drawString("Invades", 440, 80);

		//Draw the icons#
		CI.setFont (new Font(Font.DIALOG_INPUT,  Font.PLAIN, 24));

		CI.drawImage(CE203_fh17602_assignment2.Loadfiles.Strand19, 55, 140, CE203_fh17602_assignment2.Loadfiles.Strand19.getWidth()+32, CE203_fh17602_assignment2.Loadfiles.Strand19.getHeight()+32, null);
		CI.setColor(Color.CYAN);
		CI.drawString("+10 points", 120, 170);
		CI.drawImage(CE203_fh17602_assignment2.Loadfiles.Strand20, 55, 210, CE203_fh17602_assignment2.Loadfiles.Strand20.getWidth()+32, CE203_fh17602_assignment2.Loadfiles.Strand20.getHeight()+32, null);
		CI.setColor(Color.CYAN);
		CI.drawString("+20 points", 120, 235);

		CI.setColor(Color.CYAN);
		CI.setColor(Color.RED);

		//Draw the buttons
		CI.setColor (Color.LIGHT_GRAY);
		CI.setFont (new Font(Font.DIALOG_INPUT,  Font.PLAIN, 24));
		//CI.drawRect (330,340,80,40);
		g2d.setColor (Color.getHSBColor (30,40,60));

		Rectangle Start= new Rectangle (200,300,428,50);
		g2d.draw(Start);

		CI.drawString("Press Enter To Start Game", 205, 330);
		g2d.setColor (Color.getHSBColor (30,40,60));

		g2d.drawRect (200,400,428,50);

		CI.drawString("Press H To See The Top5 Scores", 205, 425);






		CI.setFont (new Font(Font.DIALOG_INPUT,  Font.PLAIN, 24));
		CI.setColor (Color.LIGHT_GRAY);
		CI.drawString ("You have been tasked to exterminate Covid!",130,600);
		CI.drawString ("Use the Masks as protection from the virus,",130,650);
		CI.drawString (	"Inject Them before they infect you!",130,700);

;


	}
	private static void top5scorescreen(Graphics g) {
		g.setColor(Color.lightGray);
		g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 40));
		g.drawString("Top 5 scores", 200, 90);

		g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 40));
		for(int i = 0; i< CE203_fh17602_assignment2.Context.top5scores.length; i++) {
			g.drawString(""+(i+1)+"=", 200, 150+i*47);
			g.drawString(""+ CE203_fh17602_assignment2.Context.top5scores[i], 389, 150+i*47);
		}
		g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));

		g.drawString("Please press any button to navigate to the menu", 100, 500);
	}


	private static void Missionfailedscreen(Graphics CI) {
		CI.setColor(Color.BLUE);
		CI.setFont (new Font(Font.DIALOG_INPUT,  Font.BOLD, 85));
		CI.drawString("Mission Failed", 50, 350);

		CI.setColor(Color.WHITE);
		CI.setFont (new Font(Font.DIALOG_INPUT, Font.PLAIN, 20));
		CI.drawString("Your score:  "+ score, 300, 450);
		CI.drawString("Press any button to return to main menu", 160, 500);
	}










}

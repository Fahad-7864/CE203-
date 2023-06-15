
import javax.imageio.ImageIO;
import javax.swing.JFrame;



import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public  class CE203_fh17602_assignment2 {

	private static JFrame App;
	private static Interface Inter;



	private static void Makeapp() {
		Inter = new Interface();
		App.add(Inter);
		Inter.requestFocusInWindow();
	}

	private static void MakeJframe() {

		App = new JFrame ("Covid-19 Invades, Created by Fahad, Fh17602");
		App.setVisible (true);
		App.setResizable (false);
		App.setBounds (100, 100, Context.windowWidth, Context.windowHeight);  //location of app startup
		App.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	}




	public static void main(String[] args) {

		MakeJframe ();
		Makeapp();
	}

	//temporary storage
	public static class Context {

		public static Covid covids[][];
		public static MultiArraylst Alst;
		public static User user;
		public static ArrayList<Shots> shots;
		public static ArrayList<covidshots> covidshots;

		public static Mask masks[];

		public static int[] top5scores = Loadfiles.rdfile();
		public static final int rowsofstrand = 6;
		public static final int lineofstrand = 8;
		public static final int windowWidth = 800;
		public static final int windowHeight = 800;
	}

	public static class Covid extends playingscrnsetup {
		private int Lofdeathanimation = 15; //how long to respawn ship
		private static int Horizontalmovement = 10;
		private static int Gamespeed = 15;  //speed at which covid strands move, decrease to make game harder
		private static int Occurence = 0;


		public Covid(int Horizonplace, int Verticalplace) {//the way to place/make the covid strands
			this.Horizontalplace =Horizonplace;
			this.Verticalplace =Verticalplace;
			this.extermnated =false;
		}
		public void lowerdeathanimationtime() {
			Lofdeathanimation--;}// lower death animation

		public static int getGamespeed() {return Gamespeed;}

		public void checkmovement() {
			Horizontalplace += Horizontalmovement;
		}//move covid strands

		public void covidbelow() {
			Verticalplace +=15;
		}//how much to move the strand down by



		public boolean makemove() {
			if(Horizontalplace <30) {//make sure covid strand does not leave left side of the screen,if it reaches these points move the strand accordingly
				Horizontalmovement =10; return true;
			}
			else if(Horizontalplace >730) {//make sure covid strand does not leave right side of the screen, if it reaches these points move the strand accordingly
				Horizontalmovement =-10; return true;
			}

			return false;
		}

		public int Hormove() {return Horizontalmovement;}



		public static void LowerGamespeed() {
			if(Gamespeed >0) Gamespeed--;
		}//- game speed


		public static int getOccurence() {return Occurence;}





		public int getLofdeathanimation() {
			return Lofdeathanimation;} //lenght


		@Override
		public Rectangle Hitbox() {
			return new Rectangle(Horizontalplace, Verticalplace, Loadfiles.Strand19.getWidth()*2, Loadfiles.Strand19.getHeight()*2);

		}
	}

	public static class Mask extends playingscrnsetup {

		private int dmgsustained;
		private Mask.shape shape;

		public Mask(int Horizontalplace, int Verticalplace, Mask.shape shape) {
			this.Horizontalplace =Horizontalplace; // create new facemask
			this.Verticalplace =Verticalplace;
			dmgsustained = 1;
			this.shape = shape;
		}
		public Mask.shape whchshpe() {return shape;}

		public int dmg() {return dmgsustained;}

		public enum shape {//determine some of the types of shapes used in the game
			Arc1,
			BSQUARE,
			SQUARE,
			arc,
		}

		public void damage() {
			dmgsustained--;}//decrease damage sustained

		public Rectangle Hitbox() {
			return new Rectangle(Horizontalplace, Verticalplace, Loadfiles.WHITEMASKSQUAREE.getWidth()+30, Loadfiles.WHITEMASKSQUAREE.getHeight()+24);

		}


	}

	public static class Loadfiles {

		//drew most images in paint
		public static final BufferedImage MEDICALSHIP = rdrsources("medicalship");
		public static final BufferedImage Strand19 = rdrsources("Strand19"); //img url https://www.flaticon.com/free-icon/virus_3654759
		public static final BufferedImage Health = rdrsources("Health");
		public static final BufferedImage injection= rdrsources("injection");
		public static final BufferedImage Strand20 = rdrsources("Strand20");//edited this one from the orignal img url https://www.flaticon.com/free-icon/coronavirus_2913604
		public static final BufferedImage WHITEMASKSQUAREE = rdrsources("white mask squaree");
		public static final BufferedImage BLUEBASKSQUARE = rdrsources("bluemasksquare");
		public static final BufferedImage arc = rdrsources("arc");
		public static final BufferedImage arcc = rdrsources("arcc");
		public static final BufferedImage explosionspirte = rdrsources("explosionsprite");//img url(https://www.clipartmax.com/max/m2H7H7G6H7G6i8N4)

		private static BufferedReader Bufferedreader;
		private static PrintWriter printWriter;

		public static int[] rdfile() {

			int[] array = new int[5];//only 5 scores allowed
			try {
				Bufferedreader = new BufferedReader(new FileReader("src/top5scores.txt"));
			} catch (FileNotFoundException eee) {
				System.out.println(" File- top5scores.txt not found");
			}

			try {
				String str = Bufferedreader.readLine();
				while(str!=null) {
					String[] strarray = str.split("=");
					array[Integer.parseInt(strarray[0])] = Integer.parseInt(strarray[1]);

					str = Bufferedreader.readLine();
				}
			} catch (IOException eee) {
				System.out.println(" error has occured whilst trying to read top5scores.txt");
			}

			return array;
		}
		private static BufferedImage rdrsources(String fileName) {
			BufferedImage fle = null;

			try {
				fle = ImageIO.read(new File("src/"+fileName+".png"));
			} catch (IOException ee) {
				System.out.println(" an error has occured when loading this src/"+fileName+".png");
			}

			return fle;
		}



		public static void crthhghsres() {

			try {
				printWriter = new PrintWriter(new File("src/top5scores.txt"));
			} catch (FileNotFoundException ee2) {
				System.out.println(" File top5scores.txt is unavailable, please check ur directory");
			}

			for(int i = 0; i< Context.top5scores.length; i++) {
				printWriter.println(i+"="+ Context.top5scores[i]);
			}
			printWriter.close();
		}
	}

	public enum Instance {

		Play,
		Menu,
		Missionfailed,
		top5scores,
	}

	public static class covidshots extends playingscrnsetup {

		private int Verticalmovement;

		public covidshots(int Horizontalplace, int Verticalplace, int Verticalmovement) {
			this.Horizontalplace =Horizontalplace;
			this.Verticalplace =Verticalplace;
			this.Verticalmovement =Verticalmovement;
		}

		public void move() {
			this.Verticalplace += Verticalmovement;
		}

		@Override
		public Rectangle Hitbox() {
			return new Rectangle(Horizontalplace, Verticalplace, 3, 12);
		}
		//parameters for covid strand virus shot hitbox
	}

	public abstract static class playingscrnsetup {
		public boolean exterminateed() {return extermnated;}
		protected int Horizontalplace;
		public int gttVerticalplace() {return Verticalplace;}
		protected int Verticalplace;
		public void setExtermnated(boolean ext) {this.extermnated =ext;}

		public int gtHorizontalplace() {return Horizontalplace;}
		public boolean extermnated;




		public abstract Rectangle Hitbox();	//set up rectangle for each class to use as a hitbox


	}

	public static class MultiArraylst {

		private int arry[][];

		public MultiArraylst() {
			//multidimensional array to store images
			arry = new int[][]
					//From top of the screen to the bottom
					{{19, 19, 19, 19, 19, 19},
							{20, 20, 20, 20, 20,20},
							{19, 19, 19, 19, 19, 19},
							{20, 20, 20, 20, 20, 20},
							{19, 19, 19, 19, 19, 19},
							{20, 20, 20, 20, 20, 20},
							{19, 19, 19, 19, 19,19},
							{20, 20, 20, 20, 20,20},};
		}
		public int whichstrand(int x, int y) {return arry[x][y];}


		public void draw(Graphics2D g2d) {
			for(int i = 0; i< arry.length; i++) {
				for(int j = 0; j< arry[i].length; j++) {

					if(!Context.covids[i][j].exterminateed ()) {
						switch(arry[i][j]) {

						case 19:
							if(Covid.getOccurence () == 0)
								g2d.drawImage(Loadfiles.Strand19, Context.covids[i][j].gtHorizontalplace (), Context.covids[i][j].gttVerticalplace (), Loadfiles.Strand19.getWidth()+20, Loadfiles.Strand19.getHeight()+20, null);
							break;

						case 20:
							if(Covid.getOccurence () == 0)
								g2d.drawImage(Loadfiles.Strand20, Context.covids[i][j].gtHorizontalplace (), Context.covids[i][j].gttVerticalplace (), Loadfiles.Strand20.getWidth()+20, Loadfiles.Strand20.getHeight()+20, null);

							break;

						}
					}
					else {
						if(Context.covids[i][j].getLofdeathanimation () > 0) {
							g2d.drawImage(Loadfiles.explosionspirte, Context.covids[i][j].gtHorizontalplace (), Context.covids[i][j].gttVerticalplace (), Loadfiles.explosionspirte.getWidth()+20, Loadfiles.explosionspirte.getHeight()+15, null);
							Context.covids[i][j].lowerdeathanimationtime ();
						}
					}
				}
			}
		}


	}

	public static class Shots extends playingscrnsetup {

		private int Verticalmovement;


		public Shots(int Horizontalplace, int Verticalplace, int Verticalmovement) {
			this.Horizontalplace =Horizontalplace;
			this.Verticalplace =Verticalplace;
			this.Verticalmovement =Verticalmovement;
		}

		public void move() {
			this.Verticalplace += Verticalmovement;
		}//moves projective

		@Override
		public Rectangle Hitbox() {
			return new Rectangle(Horizontalplace, Verticalplace, 2, 10);
		}//parameters for injection hitbox
	}

	public static class User extends playingscrnsetup {



		public User() {

			health = 3;//how much health the user spawns in with
			Horizontalplace = Context.windowWidth-450;//where the ship will spawn at the start of the game
			Verticalplace = Context.windowHeight-115;
			extermnated = false; //if true it will kill the user at the start of the game

		}

		public void gainhealth() {
			if(health < 9) health++;//health+1
		}
		public void move(int Horizontalmovement) {
			Horizontalplace +=Horizontalmovement;
		}
		public void subtracthealth() {
			health--;} //health-1
		public final int timebetweeneachshot = 40;


		public int Hlth() {return health;}

		private int health;


		@Override
		public Rectangle Hitbox() {
			return new Rectangle(Horizontalplace, Verticalplace, Loadfiles.MEDICALSHIP.getWidth()+24, Loadfiles.MEDICALSHIP.getHeight()+24);
		}//hit box for the users ship


	}

	public static class Manager extends Mask {


		public static void mveshots() {
			for (int f = 0; f < Context.shots.size (); f++) {
				Context.shots.get (f).move ();

				if (Context.shots.get (f).gttVerticalplace () < 0 || Context.shots.get (f).gttVerticalplace () > Context.windowHeight - 116) {//get rid of any shots that move below the drawn line
					Context.shots.remove (f);
				}
			}
		}

		public Manager(int Horizontalplace, int Verticalplace, Mask.shape shape) {
			super(Horizontalplace, Verticalplace, shape);
		}//create a mask




		public static void rstusertime() {
			Usertime = 0;
		}//reset time to 0

		public static void bottomstrandshoot() {
			Random rand = new Random();
			int col = rand.nextInt(Context.lineofstrand  +16);
			int row = rand.nextInt(Context.rowsofstrand +16);

			if (col >= Context.lineofstrand || row >= Context.rowsofstrand) return;
			if (Context.covids[col][row].exterminateed ()) return;


			if (row == 5) {
	// only the bottom strands can shoot
				Context.covidshots.add(new covidshots(Context.covids[col][row].gtHorizontalplace () + 20, Context.covids[col][row].gttVerticalplace () + 25, 2));
				return;
			}

			if (Context.covids[col][row +1].exterminateed ()) {
				Context.covidshots.add(new covidshots(Context.covids[col][row].gtHorizontalplace () + 20, Context.covids[col][row].gttVerticalplace () + 25, 2));

			}
		}
		public static void instantstrand() {
			Strandtime = 0;
			Context.covids = new Covid[Context.lineofstrand][Context.rowsofstrand];
			for (int i = 0; i < Context.lineofstrand; i++) {
				for (int j = 0; j < Context.rowsofstrand; j++) {
					Context.covids[i][j] = new Covid(200 + i * 45, 50 + j * 45);
				}
			}
	//		Strandtime = 0;
		}
		private static int Strandtime = 0;
		private static int Usertime = 0;


		public static int gtusertime() {
			return Usertime;
		}



		public static void strandmovement() {
			if (Strandtime == Covid.getGamespeed()) {		//make all covid strands move in the application

				horizontalstrand ();
				Strandtime = 0;
			}

			//make last covid strand move
			if (Context.covids[0][0].Hormove() > 0) {		//make last covid strand move

				if (Context.covids[Context.lineofstrand - 1][Context.rowsofstrand - 1].makemove())
					Verticalstrand ();
			} else {
				if (Context.covids[0][0].makemove())
					Verticalstrand ();
			}
		}

		private static void horizontalstrand() {	//make covid strands move horizontally

			for (int i = 0; i < Context.lineofstrand; i++) {
				for (int j = 0; j < Context.rowsofstrand; j++) {
					try {
						Context.covids[i][j].checkmovement();
					} catch (NullPointerException e) {
						continue;
					}
				}
			}
		}


		private static void Verticalstrand() {
			for (int f = 0; f < Context.lineofstrand; f++) {	//make covid strands move vertically

				for (int s = 0; s < Context.rowsofstrand; s++) {
					try {
						Context.covids[f][s].covidbelow();
					} catch (NullPointerException e) {
						continue;
					}
				}
			}
		}

		public static int gtstrandtime() {
			return Strandtime;
		}



			public static void mvecovidpjs(){
		for (int f = 0; f < Context.covidshots.size (); f++) {
				Context.covidshots.get (f).move ();

				if (Context.covidshots.get (f).gttVerticalplace () < 0 || Context.covidshots.get (f).gttVerticalplace () > Context.windowHeight - 116) {//get rid of any shots that move below the drawn line
					Context.covidshots.remove (f);
				}
			}
			}

		public static boolean shothittingplayer() {
			for (int i = 0; i < Context.covidshots.size(); i++) {
				if (Context.covidshots.get(i).Hitbox ().intersects(Context.user.Hitbox ())) {// if the covid strands shot hits the user remove a life and start the death animation
					Context.covidshots.remove(i);
					Context.user.subtracthealth ();
					return true;
				}
			}
			return false;
		}
		public static void changeDelays() {
			Strandtime++;
			Usertime++;
		}	//increase delay






		public static void reinstantize() { //when all covid strands are killed load up all the necessary resources
			Context.user = new User();
			Manager.instantstrand ();
			Context.shots = new ArrayList<Shots>();
			Context.covidshots = new ArrayList<covidshots>();

			Context.Alst = new MultiArraylst();


			Manager.instantstrand ();


			Context.masks = new Mask[]{
					//left Facemask
					//one square is 36x36 px
					new Mask(60, 616, shape.SQUARE), new Mask(180, 616, shape.SQUARE), //bottomsquares
					new Mask(60, 580, shape.SQUARE), new Mask(180, 580, shape.SQUARE), new Mask(180, 544, shape.SQUARE), new Mask(180, 508, shape.SQUARE), new Mask(60, 544, shape.SQUARE), new Mask(60, 508, shape.SQUARE),
					new Mask(144, 508, shape.BSQUARE),new Mask(144, 544, shape.BSQUARE), new Mask(96, 508, shape.BSQUARE),	new Mask(96, 544, shape.BSQUARE), new Mask(96, 472, shape.BSQUARE),	new Mask(144, 472, shape.BSQUARE), new Mask(96, 452, shape.BSQUARE),	new Mask(144, 452, shape.BSQUARE),
					new Mask(120, 508, shape.BSQUARE),new Mask(120, 544, shape.BSQUARE),//middle blue square
					new Mask(120, 472, shape.BSQUARE),new Mask(120, 472, shape.BSQUARE), new Mask(120, 452, shape.BSQUARE),
					new Mask(70, 480, shape.arc),new Mask(180, 480, shape.Arc1),

					//Facemask 2
					new Mask(300, 616, shape.SQUARE), new Mask(420, 616, shape.SQUARE), //bottomsquares
					new Mask(300, 580, shape.SQUARE), new Mask(420, 580, shape.SQUARE), new Mask(420, 544, shape.SQUARE), new Mask(420, 508, shape.SQUARE), new Mask(300, 544, shape.SQUARE), new Mask(300, 508, shape.SQUARE),
					new Mask(386, 508, shape.BSQUARE),new Mask(386, 544, shape.BSQUARE), new Mask(336, 508, shape.BSQUARE),new Mask(336, 544, shape.BSQUARE), new Mask(336, 472, shape.BSQUARE),new Mask(386, 472, shape.BSQUARE), new Mask(336, 452, shape.BSQUARE),new Mask(386, 452, shape.BSQUARE),
					new Mask(361, 508, shape.BSQUARE),new Mask(361, 544, shape.BSQUARE),//middle blue square
					new Mask(361, 472, shape.BSQUARE),new Mask(361, 472, shape.BSQUARE), new Mask(361, 452, shape.BSQUARE),
					new Mask(310, 480, shape.arc),new Mask(420, 480, shape.Arc1),


					//Facemask3
					new Mask(540, 616, shape.SQUARE), new Mask(660, 616, shape.SQUARE), new Mask(540, 580, shape.SQUARE), new Mask(660, 580, shape.SQUARE), new Mask(660, 544, shape.SQUARE), new Mask(660, 508, shape.SQUARE), new Mask(540, 544, shape.SQUARE), new Mask(540, 508, shape.SQUARE),
					new Mask(626, 508, shape.BSQUARE),new Mask(626, 544, shape.BSQUARE), new Mask(576, 508, shape.BSQUARE),new Mask(576, 544, shape.BSQUARE), new Mask(576, 472, shape.BSQUARE),new Mask(626, 472, shape.BSQUARE), new Mask(576, 452, shape.BSQUARE),new Mask(626, 452, shape.BSQUARE),
					new Mask(601, 508, shape.BSQUARE),new Mask(601, 544, shape.BSQUARE),//middle blue square
					new Mask(601, 472, shape.BSQUARE),new Mask(601, 472, shape.BSQUARE), new Mask(601, 452, shape.BSQUARE),
					new Mask(550, 480, shape.arc),new Mask(660, 480, shape.Arc1),

			};
		}


		public static void scorefromtoptobottom() {
			int appo;

			for(int f = 0; f< Context.top5scores.length-1; f++) {
				for(int s = f+1; s< Context.top5scores.length; s++) {
					if(Context.top5scores[s]> Context.top5scores[f]) {
						appo = Context.top5scores[f];
						Context.top5scores[f] = Context.top5scores[s];
						Context.top5scores[s] = appo;
					}
				}
			}

		}





		public static void shothittingfacemask() {
			for (int f = 0; f < Context.masks.length; f++) {
				for (int s = 0; s < Context.shots.size(); s++) {
					if (Context.shots.get(s).Hitbox ().intersects(Context.masks[f].Hitbox ()) && Context.masks[f].dmg () > 0) { //if the users shot/injection hits the face mask remove the square and shot
						Context.masks[f].damage();
						Context.shots.remove(s);
					}
				}
			}
		}

		public static void covidshothittingfacemask() {
			for (int q = 0; q < Context.masks.length; q++) {
				for (int e = 0; e < Context.covidshots.size(); e++) {
					if (Context.covidshots.get(e).Hitbox ().intersects(Context.masks[q].Hitbox ()) && Context.masks[q].dmg () > 0) {//if the covid strands shot hits the face mask reove the square and shot
						Context.masks[q].damage();
						Context.covidshots.remove(e);
					}
				}
			}
		}

		public static boolean collisionwithstrandsandmasks() {
			for (int i = 0; i < Context.covids.length; i++) {
				for (int j = 0; j < Context.covids[i].length; j++) {
					if (Context.covids[i][j].gttVerticalplace () > 530 && !Context.covids[i][j].exterminateed ()) {//if the covid strand reaches a certain point indicate the game over screen
						return true;
					}
				}
			}
			return false;
		}



		public static boolean injectionhitvirus() {
			for (int j = 0; j < Context.rowsofstrand; j++) {
				for (int k = 0; k < Context.shots.size(); k++) {
					for (int i = 0; i < Context.lineofstrand; i++) {

						if (Context.shots.get(k).Hitbox ().intersects(Context.covids[i][j].Hitbox ()) && !Context.covids[i][j].exterminateed ()) {

							Context.covids[i][j].setExtermnated (true);
							Context.shots.remove(k);

							switch (Context.Alst.whichstrand (i, j)) {
								case 19:
									Interface.addScore(10);//if user hits the the blue strand add 10 points to the score
									break;
								case 20:
									Interface.addScore(20);//if user hits the green strand add 10 points to the total score
									break;
							}
							return true;
						}
					}
				}
			}
			return false;
		}


	}
}

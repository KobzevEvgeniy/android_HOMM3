package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.example.Abstract_heroes.Hero;
import com.mygdx.game.example.All_Magical_heroes.Monk;
import com.mygdx.game.example.All_Magical_heroes.Wizard;
import com.mygdx.game.example.All_Other_heroes.Farmer;
import com.mygdx.game.example.All_Shooters.Arbalester;
import com.mygdx.game.example.All_Shooters.Sniper;
import com.mygdx.game.example.All_Warriors_heroes.Bandit;
import com.mygdx.game.example.All_Warriors_heroes.Spearman;
import com.mygdx.game.example.Program;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fons, arbalester, bandit, farmer, monk, sniper, spearman, wizard;
	Music music;
	Program game;
	boolean play,clk;


	@Override
	public void create () {
		game= new Program();
		game.main();
		batch = new SpriteBatch();
		fons = new Texture("fons/"+Fons.values()[new Random().nextInt(Fons.values().length)]+".png");
		music= Gdx.audio.newMusic(Gdx.files.internal("music/theme ("+(new Random().nextInt(0,4)) +")"+".mp3"));
		music.setLooping(true);
		music.setVolume(1);
		music.play();
		play=clk=true;

		arbalester=new Texture("hero/Arbalester.png");
		bandit=new Texture("hero/Bandit.png");
		farmer= new Texture("hero/Farmer.png");
		monk = new Texture("hero/Monk.png");
		sniper= new Texture("hero/Sniper.png");
		spearman= new Texture("hero/Spearman.png");
		wizard = new Texture("hero/Wizard.png");


	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(fons, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		int kx=Gdx.graphics.getWidth()/12;
		int ky=Gdx.graphics.getHeight()/15;

		for (Hero hero: game.team1){
			if (hero.isDead()) continue;
			if (hero instanceof Arbalester) batch.draw(arbalester, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky);
			if (hero instanceof Sniper) batch.draw(sniper, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky);
			if (hero instanceof Bandit) batch.draw(bandit, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky);
			if (hero instanceof Farmer) batch.draw(farmer, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky);
			if (hero instanceof Spearman) batch.draw(spearman, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky);
			if (hero instanceof Monk) batch.draw(monk, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky);
			if (hero instanceof Wizard) batch.draw(wizard, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky);
		}

		for (Hero hero: game.team2){
			if (hero.isDead()) continue;
			if (hero instanceof Arbalester) batch.draw(arbalester, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky, -arbalester.getWidth(), arbalester.getHeight());
			if (hero instanceof Sniper) batch.draw(sniper, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky, -sniper.getWidth(),sniper.getHeight());
			if (hero instanceof Bandit) batch.draw(bandit, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky, -bandit.getWidth(),bandit.getHeight());
			if (hero instanceof Farmer) batch.draw(farmer, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky, -farmer.getWidth(),farmer.getHeight());
			if (hero instanceof Spearman) batch.draw(spearman, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky, -spearman.getWidth(),spearman.getHeight());
			if (hero instanceof Monk) batch.draw(monk, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky, -monk.getWidth(), monk.getHeight() );
			if (hero instanceof Wizard) batch.draw(wizard, hero.position.toArray()[0]*kx,hero.position.toArray()[1]*ky,  -wizard.getWidth(),wizard.getHeight());
		}
		batch.end();

		if (Gdx.input.isTouched() & play & clk){
			if (!game.run()){
				play=false;
				Gdx.graphics.setTitle("Game over!");
				music.stop();
			}
			clk=false;

		}
		if (!Gdx.input.isTouched())clk=true;
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fons.dispose();
		music.dispose();
		arbalester.dispose();
		bandit.dispose();
		farmer.dispose();
		monk.dispose();
		sniper.dispose();
		spearman.dispose();
		wizard.dispose();
	}



}

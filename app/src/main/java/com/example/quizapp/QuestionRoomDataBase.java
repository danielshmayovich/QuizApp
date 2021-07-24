package com.example.quizapp;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Questions.class},version = 6)
abstract class QuestionRoomDatabase extends RoomDatabase {

    private static QuestionRoomDatabase INSTANCE;
    public abstract QuestionDao questionDao();

    public static synchronized QuestionRoomDatabase getInstance(final Context context) {

        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    QuestionRoomDatabase.class, "questions_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(RoomDBCallback)
                    .build();
        }

        return INSTANCE;

    }

    private static RoomDatabase.Callback RoomDBCallback = new RoomDatabase.Callback() {


        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private QuestionDao questionDao;


        private PopulateDbAsyncTask(QuestionRoomDatabase db) {

            questionDao = db.questionDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            questionDao.insert(new Questions("Who won the world cup in 2014?", "Argentina", "Brazil", "Germany", "France", 3,"Sport", "en"));
            questionDao.insert(new Questions("Who won the world cup in 2014?", "Argentina", "Brazil", "Germany", "France", 3,"Sport", "he"));



            questionDao.insert(new Questions("How many Grand Slam titles Rafael Nadal have?","20", "25", "18","15", 1,"Sport", "en"));
            questionDao.insert(new Questions("The Olympics are held every how many years?","5", "2", "4","8", 3,"Sport", "en"));
            questionDao.insert(new Questions("Tiger Woods is a","Swimmer", "Basketball coach", "Tennis player","Golf player", 4,"Sport", "en"));
            questionDao.insert(new Questions("The last teem Michael Jordan played for was","LA Lakers", "Washington Wizards", "Chicago bulls","NY Knicks",  2,"Sport", "en"));
            questionDao.insert(new Questions("Cristiano Ronaldo plays for","Portugal", "Spain", "Argentina","Chile", 1,"Sport", "en"));
            questionDao.insert(new Questions("The NFL is the top league for","Basketball", "Soccer", "Hockey","Football", 4,"Sport", "en"));
            questionDao.insert(new Questions("Which of the following won the Champions League","Neymar", "Paul Pogba", "Antoine Griezmann","Eden Hazard ", 1,"Sport", "en"));
            questionDao.insert(new Questions("Which of the following clubs is not from London","Tottenham", "Chelsea", "Everton","Arsenal", 3,"Sport", "en"));
            questionDao.insert(new Questions("Who is the top scorer in the history of the EuroLeague","Juan Carlos Navarro", "Spanoulis", "Anthony Parker","Diamantidis", 2,"Sport", "en"));

            questionDao.insert(new Questions("In which year did Justin Bieber release Baby","2012", "2009", "2006","2007", 2,"Music", "en"));
            questionDao.insert(new Questions("Who sang in James Bond movie (Skyfall)","Adele", "Rihanna", "Tina Turner","Madonna", 1,"Music", "en"));
            questionDao.insert(new Questions("What is the real name of Elton john","Paul David Hewson", "Robyn Fenty", "Stevland Hardaway Judkins","Reginald Dwight", 4,"Music", "en"));
            questionDao.insert(new Questions("Robert Plant was the lead singer of which rock band","Green Day", "The Rembrandts", "Led Zeppelin","Guro", 3,"Music", "en"));
            questionDao.insert(new Questions("Who was the youngest beatle","Paul McCarthney", "Ringo Starr", "George Harrison","John Lennon", 3,"Music", "en"));
            questionDao.insert(new Questions("Celine Dion won the Eurovision for","France", "Swiss", "Spain","Israel", 2,"Music", "en"));

            questionDao.insert(new Questions("What planet is closest to the sun","Mercury", "Neptune", "Jupiter","Venus", 1,"Science", "en"));
            questionDao.insert(new Questions("What is the largest planet","Mercury", "Neptune", "Jupiter","Venus", 3,"Science", "en"));
            questionDao.insert(new Questions("How many continents are there in the world","7", "4", "5","9", 1,"Science", "en"));

            questionDao.insert(new Questions("Who is 007","Superman", "James Bond", "Ben Afflek","Richard Harrison", 2,"Movies", "en"));
            questionDao.insert(new Questions("Who is part of the Avengers","Batman", "Doom", "Wolverine","Hulk", 4,"Movies", "en"));
            questionDao.insert(new Questions("Who directed \"Kill Bill\"","Tarantino", "Spielberg", "Scorsese Martin","Christopher Nolan", 1,"Movies", "en"));
            questionDao.insert(new Questions("Who directed \"Inception\"","Tarantino", "Spielberg", "Scorsese Martin","Christopher Nolan", 4,"Movies", "en"));
            questionDao.insert(new Questions("Who played \"The Gladiator\"","Gerard Butler", "Tom Cruz", "Russell Crowe","Brad Pitt", 2,"Movies", "en"));
            questionDao.insert(new Questions("Who played \"The Mask\"","Jim Carrey", "Sasha Baron Cohen", "Adam Sandler","Brad Pitt", 1,"Movies", "en"));


            questionDao.insert(new Questions("Which popular company designed the first CPU","Apple", "Dell", "Intel","IBM", 3,"Technology", "en"));
            questionDao.insert(new Questions("Which of the following is not a web browser","Chrome", "Google-Drive", "Safari","Edge", 2,"Technology", "en"));
            questionDao.insert(new Questions("What company developed a computer with the codename \"Lisa\"","Apple", "Microsoft", "Intel","IBM", 1,"Technology", "en"));
            questionDao.insert(new Questions("What does \"IT\" stand for","Integrated Technology", "Individual Technology", "Information Technology","Implied Technology", 3,"Technology", "en"));
            questionDao.insert(new Questions("Which of the following is not a software language","PHP", "C++", "C#","Docker", 4,"Technology", "en"));
            questionDao.insert(new Questions(" When was the internet created","1968", "1972", "1989","1992", 1,"Technology", "en"));
            questionDao.insert(new Questions("How many bits make a byte","16 bits", "8 bits", "24 bits","12 bits", 2,"Technology", "en"));
            questionDao.insert(new Questions("What is the meaning of CPU","Central Processing Unit", "Critical Processing Unit", "Crucial Processing Unit","Central Printing Unit", 1,"Technology", "en"));


            return null;
        }
    }
}




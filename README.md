# API REST Web Resources x Spittr Application
 
 Applicazione Spring Boot che mette a disposizione API REST per fornire servizi relativi all'applicazione "spittr".
 
 Tra le altre features fa uso di:
 <ul>
    <li>
        Spring Security (Autenticazione, Autorizzazione, HTTP Basic, Encryption di password utente nel DB)
    </li>
    <li>
        Sviluppo componenti DAO (Repository) per gestione della persistenza dei dati utilizzando DBMS MySql. I componenti @Repository così creati (JdbcSpitterRepository, JdbcSpittleRepository) utilizzano JPA/Hibernate.
    </li>
 </ul>
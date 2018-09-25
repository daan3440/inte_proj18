#Ickefunktionella krav
##Ickefunktionella krav
Detta avsnitt sammanfattar alla ickefunktionella krav på projektet.
###Grupparbete
Projektet ska vara ett grupparbete. Om någon i gruppen inte deltar, eller för den skull gör en alltför stor del av arbetet själv, så är det inte ett grupparbete.
###Verktyg
Allt arbete ska versionshanteras. Detta gäller kod, test, byggscript, dokumentation och rapporterna. Från versionshanteringshistoriken ska det tydligt framgå att alla deltagit i arbetet. Vid redovisningen måste versionhanteringssystemet vara tillgängligt. Rekommendationen är att gruppen har med sig en egen dator till redovisningen, annars måste ni se till att kursledningen har tillgång till ert versionshanteringssystem i förväg.

Ett enhetstestramverk i stil med JUnit ska användas. Ni får gärna använda andra typer av testverktyg också om ni tycker de tillför något, men detta är inget krav.

Ett byggscript, till exempel Maven eller Ant, ska kunna användas för att bygga och testa systemet.

Efter att ni genomfört granskningen (se nedan) och rättat de saker som kommit fram så ska ni testa minst ett kodkritiksystem, till exempel Findbugs, på koden. Detta ska göras både på koden som den ser ut då, och på koden som den såg ut innan ni granskade den. Vilka typer av fel hittar verktyget? Är det samma fel som ni hittade?

När ni är klara med projektet så ska ni använde ett verktyg i stil med Metrics 1.3 för att ta fram statiska mått på koden. Dessa ska redovisas i slutrapporten tillsammans med de slutsatser ni drar av dem. Det räcker alltså inte med att bara upprepa den information som siffrorna själva ger, utan ni måste kunna tolka dem också.

Ett minimikrav på era tester är att de uppnår 100% täckningsgrad på programsatserna i koden. Detta ska visas med hjälp av ett verktyg i stil med Emma. Testa gärna även att försöka uppnå högre nivåer av täckningsgrad på någon mindre del av koden.

Slutligen ska ni också testa på att använda en profiler på koden. Här är det lämpligt att ni väljer ut någon intressant del av koden och skriver ett speciellt test eller testprogram som bara är till för att ni ska köra profilern på det. Detta är test blir kanske inte helt realistiskt, men eftersom det inte ingår i uppgiften att implementera ett tillämpningsprogram så får vi göra så.

Ni får gärna testa på att använda andra typer av verktyg, till exempel byggservrar eller ärendehanteringssystem, men detta är inget krav. Om ni vill kan ni också byta ut några funktionella krav på uppgiften och istället implementera ett grafiskt användarinterface för någon mindre del och testa det.

###Testdriven utveckling
Ni ska tillämpa testdriven utveckling under projektet, och detta ska gå att följa i versionshistoriken.
Granskning
Ni ska genomföra minst en formell granskning av koden. Testa gärna mer informella typer av granskningar också så att ni har något att jämföra med. Ett tips är att prata med någon annan grupp och granska varandras kod.
###Testdesigntekniker
Ni ska välja ut några lämpliga delar av projektet och tillämpa minst två av de tre testdesigntekniker som tagits upp under kursen: ekvivalensklassuppdelning, beslutstabeller och tillståndsmaskiner. De testfall som tas fram på dessa sätt kan utgöra grunden för utveckling av dessa delar med TDD eller tas fram i efterhand för att komplettera de testfall som ni redan har tagit fram genom att tillämpa testdriven utveckling.

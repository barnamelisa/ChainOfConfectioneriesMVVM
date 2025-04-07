# Cofetărie Management System 🍰 - Aplicație pentru Gestiunea Prăjiturilor

Această aplicație software este destinată gestiunii prăjiturilor vândute de cofetăriile unui lanț de cofetării. Aplicația permite adăugarea, ștergerea și actualizarea informațiilor despre cofetării și prăjituri, vizualizarea listelor de cofetării și prăjituri, filtrarea prăjiturilor, căutarea după denumire și salvarea lor în fișiere de tip CSV și DOC.

Aplicația utilizează **JavaFX** pentru interfața grafică și arhitectura **MVVM (Model-View-ViewModel)** pentru o separare clară a logicii aplicației.

## Funcționalități 🛠️

Aplicația include următoarele funcționalități:

### 1. **Gestiunea Cofetăriilor 🏠**
   - **Adăugarea de noi cofetării 📝:** Permite introducerea de cofetării noi cu informații precum denumirea și adresa.
   - **Ștergerea cofetăriilor ❌:** Permite eliminarea unei cofetării din lanț.
   - **Actualizarea informațiilor despre cofetării ✏️:** Permite modificarea detaliilor unei cofetării existente.
   - **Vizualizarea listei de cofetării 👀:** Afișează toate cofetăriile din lanț, incluzând detalii precum denumirea și adresa fiecărei cofetării.

### 2. **Gestiunea Prăjiturilor 🎂**
   - **Adăugarea de noi prăjituri 🧁:** Permite adăugarea de prăjituri noi cu informații detaliate despre fiecare (denumire, descriere, valabilitate, disponibilitate).
   - **Ștergerea prăjiturilor ❌:** Permite eliminarea prăjiturilor din sistem.
   - **Actualizarea informațiilor despre prăjituri ✏️:** Permite modificarea detaliilor unei prăjituri.
   - **Vizualizarea listei de prăjituri 🍩:** Afișează toate prăjiturile din lanțul de cofetării, sortate după denumire. Fiecare prăjitură va include o imagine reprezentativă.
   - **Filtrarea prăjiturilor 🔍:** Permite filtrarea prăjiturilor dintr-o cofetărie selectată, pe baza criteriilor de disponibilitate sau valabilitate.

### 3. **Căutare și Export 💾**
   - **Căutarea prăjiturilor după denumire 🔍:** Permite căutarea prăjiturilor în sistem pe baza denumirii.
   - **Exportul prăjiturilor expirate sau epuizate 📊:** Permite salvarea listei de prăjiturii expirate sau epuizate într-un fișier CSV și DOC.

## Arhitectura Aplicației 🏗️

Aplicația urmează arhitectura **MVP (Model-View-Presenter)**:
- **Model 🗃️**: Gestionarea datelor și interacțiunea cu baza de date.
- **View 👁️**: Interfața grafică a utilizatorului (GUI) care interacționează cu utilizatorul.
- **Presenter 🎤**: Logica aplicației care coordonează comunicarea între View și Model.

## Instalare și Configurare ⚙️

1. **Clonarea depozitului**:
   ```bash
   git clone https://bitbucket.org/<your-username>/<repository-name>.git
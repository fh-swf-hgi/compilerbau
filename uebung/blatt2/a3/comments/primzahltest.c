/* Einfache Funktion zum Testen, ob
 * eine ganze Zahl eine Primzal ist
 */
void ist_prim(int zahl) {

    int i;
	// 2 ist die kleinste Primzahl
	if (zahl < 2) return 0;
	/* Teste alle Zahlen bis n/2.
	 * Es würde genügen bis sqrt(n) zu testen.
	 */
    for ( i=2; i<zahl/2; i++){
		// Ist die Zahl durch i teilbar?
        if(zahl%i==0){
            printf("%d ist keine Primzahl (%d/%d=%d)\n", zahl, zahl, i, zahl/i);
            return;
        }
    }
	// Die Zahl ist nicht durch andere Ints >1 teilbar -> Prim!
    printf("%d ist eine Primzahl\n", zahl);
}

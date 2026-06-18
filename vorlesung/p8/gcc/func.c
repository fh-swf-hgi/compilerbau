int func(int x){
	int y = 2;
	int z = 3;
	int sum = 0;
	for(int i=0; i<10; ++i){
		sum += i * x * y + z*i;
	}
	return sum/100;
}

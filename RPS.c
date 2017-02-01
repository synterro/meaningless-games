#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void rock(int n) {
	if (n==0) {
		printf("Computer chose rock! It's a draw.\n");
	}
	else if (n==1) {
		printf("Computer chose scissors! Congratulations, you win.\n");
	}
	else {
		printf("Computer chose paper! Sorry, you lose.\n");
	}
}

void paper(int n) {
	if (n==0) {
		printf("Computer chose rock! Congratulations, you win.\n");
	}
	else if (n==1) {
		printf("Computer chose scissors! Sorry, you lose.\n");
	}
	else {
		printf("Computer chose paper! It's a draw.\n");
	}
}

void scissors(int n) {
	if (n==0) {
		printf("Computer chose rock! Sorry, you lose.\n");
	}
	else if (n==1) {
		printf("Computer chose scissors! It's a draw.\n");
	}
	else {
		printf("Computer chose paper! Congratulations, you win.\n");
	}
}

int main() {
	srand(time(NULL));
	char answer;
	printf("Scissors, Paper, Rock!\n");
	printf("aka Rock, Paper, Scissors!\n");
	printf("aka Jan Ken Pon!\n");
	printf("Do you choose Rock, Paper, or Scissors? (type 'R', 'P', or 'S')\n");
	scanf("%c", &answer);
	int r = rand() % 3;
	
	if (answer=='R') {
		rock(r);
	}
	else if (answer=='P') {
		paper(r);
	}
	else if (answer=='S') {
		scissors(r);
	}
	else {
		printf("Invalid answer; try again later\n");
		exit(0);
	}
	
	return 0;
}




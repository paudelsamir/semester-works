#include <stdio.h>
#include <math.h>

void drawLineDDA(int x0, int y0, int x1, int y1);

int main() {
    int x0 = 10, y0 = 12;  // Starting point A(10,12)
    int x1 = 15, y1 = 17;  // Ending point B(15,17)

    drawLineDDA(x0, y0, x1, y1);

    return 0;
}

void drawLineDDA(int x0, int y0, int x1, int y1) {
    int dx = x1 - x0;
    int dy = y1 - y0;

    int steps = abs(dx) > abs(dy) ? abs(dx) : abs(dy);

    float Xinc = dx / (float) steps;
    float Yinc = dy / (float) steps;

    float x = x0;
    float y = y0;

    printf("X\tY\n");
    for (int i = 0; i <= steps; i++) {
        printf("%.0f\t%.0f\n", round(x), round(y));
        x += Xinc;
        y += Yinc;
    }
}

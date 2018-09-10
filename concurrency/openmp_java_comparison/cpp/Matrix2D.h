#include <iostream>
#include <omp.h>

class Matrix2D {

    Matrix2D();
    ~Matrix2D();
    Matrix2D add( Matrix2D* arg );
    Matrix2D subtract( Matrix2D* arg );
    Matrix2D multiply( Matrix2D* arg );

};

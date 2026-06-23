## Part 1: Chapter-wise Important Questions

### Unit 1: Introduction to Data Warehousing

1. What is data mart? Why do we need multidimensional data model? *(2082)* [5]
2. What is a data warehouse? How is it different from a database? What is data mart? *(Model Set)* [5]
3. When do we prefer trim mean for statistical description of data? Justify with an example. Describe about multi-dimensional data model and conceptual modeling of data warehouse. *(2081)* [10]
4. List any two OLAP operations with example. How do you compute rule coverage and rule accuracy? *(2081)* [5]
5. Explain the different components of data warehouse. How data cube precomputation is performed? Describe. *(Model Set II)* [10]
6. Why the concept of data mart is important? Discuss different data warehouse schema with examples. *(2080)* [10]
7. Explain the OLAP operations with examples. *(2080)* [5]
8. Write down short notes on: Support Vector Machine and Multi-dimensional Data Model. *(2080)* [5]
9. Write down short notes on: Data Mart and Market Basket Analysis. *(2079)* [5]
10. Why OLAP operations are used? Discuss various OLAP operation with suitable example of each. *(2079)* [10]
11. Write down any one advantage and disadvantage of MOLAP over ROLAP. Define signed network and how do you check whether it is balanced or not? How beam search reduces the space complexity? Illustrate with an example. *(2078)* [10]
12. Differentiate between star schema and snow flake schema. List any two methods for data normalization. *(2078)* [5]



### Unit 2: Introduction to Data Mining

1. Describe the different types of data object and attribute types. *(2082)* [5]
2. What is KDD? Explain with a suitable block diagram. *(Model Set)* [5]
3. How KDD differs from data mining? Explain various stages of KDD with suitable block diagram. *(2080)* [5]
4. Discuss different types of attributes with suitable example of each. *(2079)* [5]
5. When a pattern is said to be interesting? List the issues of data mining. *(2078)* [5]



### Unit 3: Data Preprocessing

1. Explain about data mining primitives. *(2082)* [5]
2. What is centroid based clustering? Why is k-means clustering called a centroid based clustering algorithm? Cluster the following instances of given data with the help of K means algorithm (Take K = 2, use first and last data points as initial centroids):

    Instance | X  | Y
    ---------|----|----
    P1       | 2  | 3
    P2       | 3  | 4
    P3       | 6  | 8
    P4       | 7  | 9
    P5       | 8  | 10
    P6       | 9  | 11

    *(Model Set)* [10]
3. Describe any two methods of handling noisy data. *(2081)* [5]
4. Discuss different ways of smoothing noisy data along with suitable examples. *(2080)* [5]
5. Why data normalization is important in data mining? Explain min-max and Z-score normalization approach. *(2079)* [5]
6. How concept hierarchy is used in extracting information? Generate the frequent pattern from the following data set using FP growth, where minimum support=3. *(2078)* [10]
7. Define data discretization. Describe the tasks for data preprocessing. *(2078)* [5]
8. Why data preprocessing is mandatory? Justify. *(Model Set II)* [5]





### Unit 4: Data Cube Technology

1. What is data cube? List the different variations of cube materializations. *(2082)* [5]
2. What is Cube materialization? Define Full cube, Iceberg cube, closed cube and Shell cube. *(Model Set)* [5]
3. What is data integration? What is data reduction? Why is data preprocessing important? *(Model Set)* [5]
4. Explain the general strategies for cube computation. *(2081)* [5]
5. How many cuboids are possible from 5-dimensional data? Discuss the concept of full cube and iceberg cube. *(2080)* [5]
6. Suppose that we have 5 dimensional data. What will be total number of cuboids generated? If we consider each dimension has 5 levels, what will be the number of cuboids generated? *(2079)* [5]
7. What are the choices for data cube materialization? Explain the strategies for cube computation. *(2078)* [5]
8. Describe any five types of OLAP operations. *(Model Set II)* [5]





### Unit 5: Mining Frequent Patterns

1. Define strong association rule. What are the limitations of Apriori algorithm? Create a FP tree from the following data set.

    TID | List of Items
    ----|--------------
    T1  | {A, B, C}
    T2  | {B, C, D}
    T3  | {C, D}
    T4  | {B, D}
    T5  | {A, C}
    T6  | {A, C, D}

    *(2082)* [10]
2. What is the Apriori principle? How is it used by the Apriori algorithm for frequent pattern mining? What are the limitations of Apriori approach? Use the APRIORI algorithm to generate strong association rules from the following transaction database. Use min_sup=40% and min_confidence=75%.

    Transaction ID | Items Purchased
    ---------------|----------------
    T1             | Bread, Milk, Eggs, Butter
    T2             | Bread, Milk, Cheese
    T3             | Milk, Eggs, Cheese, Yogurt
    T4             | Bread, Butter, Cheese
    T5             | Bread, Milk, Butter, Yogurt

    *(Model Set)* [10]
3. What is a frequent pattern? What is market basket analysis? Explain it with suitable examples. *(Model Set)* [5]
4. How do you generate strong association rules? From the following dataset find the frequent item set using FP growth algorithm using 3 as minimum support.

    Transaction ID | Items
    ---------------|-----------
    T1             | {K, E, M, O, Y}
    T2             | {K, E, O, Y}
    T3             | {K, E, M}
    T4             | {K, M, Y}
    T5             | {K, E, O}

    *(2081)* [10]
5. Given the following data set, find the frequent itemset using Apriori algorithm with minimum support 3.

    TID | Items
    ----|----------------
    T1  | {A, B, C, D, E, F}
    T2  | {B, C, D, E, F, G}
    T3  | {A, D, E, H}
    T4  | {A, D, F, I, J}
    T5  | {B, D, E, K}

    *(Model Set II)* [5]
6. State Apriori property. Find frequent item sets and association rules from the transaction database given below using Apriori algorithm. Assume min. support is 50% and min confidence is 75%.

    Transaction ID | Items Purchased
    ---------------|----------------
    1              | Bread, Cheese, Egg, Juice
    2              | Bread, Cheese, Juice
    3              | Bread, Milk, Yogurt
    4              | Bread, Juice, Milk
    5              | Cheese, Juice, Milk

    *(2080)* [10]
7. Discuss any two drawbacks of Apriori algorithm. Find frequent item-sets and association rules from the transaction database given below using FP-growth algorithm. Assume minimum support is 50% and minimum confidence is 60%.

    Transaction ID | Items purchased
    ---------------|----------------
    1              | Sausage, peanut, Beer
    2              | peanut, Beer, Apple
    3              | Apple, Milk
    4              | Sausage, peanut, Apple
    5              | Sausage, peanut, Beer, Milk
    6              | Sausage, peanut, Beer, Apple

    *(2079)* [10]



### Unit 6: Classification and Prediction

1. Define support vector. Write the algorithm for back propagation for classification. *(2082)* [5]
2. What is the role of Laplace smoothing? Create a decision tree from the following data set using ID3 as attribute selection approach.

    Object | A1 | A2 | Class
    -------|----|----|------
    1      | T  | T  | C1
    2      | T  | T  | C1
    3      | T  | F  | C2
    4      | F  | F  | C1
    5      | F  | T  | C2
    6      | F  | T  | C2

    *(2082)* [10]
3. What is a rule based classifier? How to extract the rules from the decision tree? What is overfitting? How to detect overfitting? Explain the way to solve the overfitting problem. Train ID3 classifier using the dataset given below. Then predict the class label for the new data sample [Weather=Sunny, Temperature=Hot, Humidity=Normal, Wind=Strong].

    Weather | Temperature | Humidity | Wind   | Class
    --------|-------------|----------|--------|-------
    Sunny   | Hot         | High     | Weak   | No
    Sunny   | Hot         | High     | Strong | No
    Overcast| Hot         | High     | Weak   | Yes
    Rain    | Mild        | High     | Weak   | Yes
    Rain    | Cool        | Normal   | Weak   | Yes
    Rain    | Cool        | Normal   | Strong | No
    Overcast| Cool        | Normal   | Strong | Yes
    Sunny   | Mild        | High     | Weak   | No
    Sunny   | Cool        | Normal   | Weak   | Yes
    Rain    | Mild        | Normal   | Weak   | Yes
    Sunny   | Mild        | Normal   | Strong | Yes
    Overcast| Mild        | High     | Strong | Yes
    Overcast| Hot         | Normal   | Weak   | Yes
    Rain    | Mild        | High     | Strong | No

    *(Model Set)* [10]
4. What is a confusion matrix? Explain the importance of confusion matrix in measuring the performance of classification models. *(Model Set)* [5]
5. Define overfitting and under fitting. Train the decision tree classifier using the ID3 algorithm based on the following training data.

    TID | Age  | Car Type | Class
    ----|------|----------|------
    1   | ≤30  | Family   | High
    2   | ≤30  | Sports   | High
    3   | >30  | Sports   | High
    4   | >30  | Family   | Low
    5   | >30  | Truck    | Low
    6   | ≤30  | Family   | High

    *(2081)* [10]
6. What is support vector? How do you evaluate the accuracy of a classifier? Describe. *(2081)* [5]
7. Consider the following training data set. *(Model Set II)* [10]
8. Discuss about overfitting and underfitting. How precision and recall is used to evaluate classifier. *(Model Set II)* [5]
9. How classification differs from regression. Train ID3 classifier using the dataset given below. Then predict class label for the data [Age=Mid, Competition=Yes, Type=HW]. *(2080)* [10]
10. Which algorithm is used for training multi-layer perceptron? Discuss the algorithm in detail. *(2080)* [5]
11. What is confusion matrix? Discuss various classification measures along with their mathematical formulae. *(2079)* [5]
12. How do you compare two classifiers? Given the points A(3,7), B(4,6), C(5,5), D(6,4), E(7,3), F(6,2), G(7,2) and H(8,4), find the core points, border points and outliers using DBSCAN. Take Eps 2.5 and MinPts = 3. *(2078)* [10]
13. How do you evaluate the accuracy of a classifier? Discuss the advantages of using K-fold cross validation. *(2078)* [5]
14. Consider the following data set.

    Confident | Studied | Sick | Result
    ----------|---------|------|-------
    Yes       | No      | No   | Fail
    Yes       | No      | No   | Pass
    No        | Yes     | Yes  | Fail
    No        | Yes     | Yes  | Pass
    Yes       | Yes     | Yes  | Pass

    Find out whether the object with attribute Confident = Yes, Sick = No will Fail or Pass using Bayesian classification. *(2078)* [5]

### Unit 7: Cluster Analysis

1. Given the following distance matrix, find the core points and outliers using DBSCAN. Take Eps = 2.5 and MinPts = 3.

    | Data Points | A    | B    | C    | D    | E    | F    | G    | H    |
    |-------------|------|------|------|------|------|------|------|------|
    | A           | 0    | 1.41 | 2.83 | 4.24 | 5.66 | 5.83 | 6.40 | 5.83 |
    | B           | 0    | 1.41 | 2.82 | 4.24 | 4.47 | 5.00 | 4.47 |
    | C           | 0    | 1.41 | 2.82 | 3.16 | 3.60 | 3.16 |
    | D           | 0    | 1.41 | 2.00 | 2.24 | 2.00 |
    | E           | 0    | 1.41 | 1.00 | 1.41 |
    | F           | 0    | 1.00 | 2.82 |
    | G           | 0    | 2.24 |
    | H           | 0    |

    *(2082)* [5]
2. Consider the data set (6,3), (7,2), (4,8), (2,2), (0,2), (9,0). Taking k=3, show the result after first iteration using k-means algorithm. For choosing initial centroid, use k-means++ by taking (6,3) as initial cluster center. *(2082)* [10]
3. What is clustering? How is it different from supervised classification? What is the DBSCAN algorithm? *(Model Set)* [5]
4. Using k-means++ algorithm and Euclidean distance, find the initial 3 cluster centroids from A1 = (3, 11), A2 = (3, 6), A3 = (9, 5), A4 = (6, 9), A6 = (7, 5), A7 = (2, 3), A8 = (5, 10). Choose (3, 11) as one of the initial centroids. *(2081)* [5]
5. Differentiate between k-means and k-medoids clustering algorithm. *(2081)* [5]
6. What is the concept mini batch k-means? How DBSCAN works? *(Model Set II)* [5]
7. Illustrate the hierarchical clustering with an example. *(Model Set II)* [5]
8. How K-medoids clustering differs from K-means clustering? Divide the following data points into two clusters using k-medoids algorithm. Show computation up to 3 iterations. {(70,85), (65,80), (72,88), (75,90), (60,50), (64,55), (62,52), (63,58)}. *(2080)* [5]
9. Discuss working of DBSCAN algorithm. *(2080)* [5]
10. Write the limitation of Apriori algorithm. Given the objects P1(2,3), P2(4,5), P3(10,40), P4(60,55), P5(70,80), apply K-means algorithm (K = 2) to show the final clusters after 2 iterations. Assume P1 and P3 as initial cluster centroids. *(Model Set II)* [10]
11. Discuss the concept of K-means++ and Mini-batch K-means algorithm. *(2079)* [5]
12. What are two categories of hierarchical clustering? Divide the following data points into two clusters using agglomerative clustering. {(2,10), (2,5), (8,4), (5,8), (7,5), (6,4)}. *(2079)* [5]
13. Apply K(=2)-Means algorithm over the data (185, 72), (170, 56), (168, 60), (179, 68), (182, 72), (188, 77) up to two iterations and show the clusters. Initially choose first two objects as initial centroids. *(2078)* [5]



### Unit 8: Graph Mining and Social Network Analysis

1. List the components of data warehouse. Discuss about the trust propagation on social network. *(2082)* [5]
2. What is the concept behind beam search? Discuss about theory of balance and status. *(2082)* [5]
3. Define social network analysis. What is the motivation behind link mining? *(Model Set)* [5]
4. Define link mining. What are the roles of epsilon and MinPts in DBSCAN? *(2081)* [5]
5. Define graph mining. Discuss the conflict between theory of balance and theory of status. *(2081)* [5]
6. How trust and distrust propagate in social network? Explain. *(Model Set II)* [5]
7. How beam search and logic programming is used to mine graph? Explain. *(Model Set II)* [5]
8. What are application areas of graph mining? Explain the concept behind inductive logic programming with suitable demonstration. *(2079)* [5]
9. When multilayer perceptron is better choice over other classification algorithms? Consider a multilayer feed-forward neural network given below. Let the learning rate be 0.5. Assume initial values of weights and biases as given in the table below. Train the network for the training tuples (1, 1, 0) and (0, 1, 1), where last number is target output. Show weight and bias updates by using back-propagation algorithm. Assume that sigmoid activation function is used in the network.

    w13 | w14 | w23 | w24 | w35 | w45 | b3  | b4  | b5
    ----|-----|-----|-----|-----|-----|-----|-----|-----
    0.5 | 0.2 | -0.3 | 0.5  | 0.1 | 0.3 | 0.6 | -0.4 | 0.8

    *(2079)* [10]
10. Show the conflict between theory of balance and status. How do you improve Apriori? *(2078)* [5]





### Unit 9: Mining Spatial, Multimedia, Text and Web Data

1. Explain about web content, web usage and web structure mining. *(2082)* [5]
2. What is text mining? What do you mean by web mining? Define NLP. [5]
3. Distinguish between data characterization and data discrimination. What are the challenges of multimedia mining? *(2081)* [5]
4. Discuss the concept of multimedia data mining along with the concept of similarity search. *(2080)* [5]
5. List any two challenge of multimedia mining. Differentiate between web usage mining and web content mining. *(Model Set II)* [5]
6. Discuss the concept of text mining with its practical implications. *(2079)* [5]
7. Define spatial data mining. What are the challenges of multimedia mining? Describe with an example. *(2078)* [5]





## Part 2: Year-wise Question Bank

### Model Set

**Group A (Attempt any TWO questions)**

1. What is the Apriori principle? How is it used by the Apriori algorithm for frequent pattern mining? What are the limitations of Apriori approach? Use the APRIORI algorithm to generate strong association rules from the following transaction database. Use min_sup=40% and min_confidence=75%.

    Transaction ID | Items Purchased
    ---------------|----------------
    T1             | Bread, Milk, Eggs, Butter
    T2             | Bread, Milk, Cheese
    T3             | Milk, Eggs, Cheese, Yogurt
    T4             | Bread, Butter, Cheese
    T5             | Bread, Milk, Butter, Yogurt

    [10]
2. What is a rule based classifier? How to extract the rules from the decision tree? What is overfitting? How to detect overfitting? Explain the way to solve the overfitting problem. Train ID3 classifier using the dataset given below. Then predict the class label for the new data sample [Weather=Sunny, Temperature=Hot, Humidity=Normal, Wind=Strong].

    Weather | Temperature | Humidity | Wind   | Class
    --------|-------------|----------|--------|-------
    Sunny   | Hot         | High     | Weak   | No
    Sunny   | Hot         | High     | Strong | No
    Overcast| Hot         | High     | Weak   | Yes
    Rain    | Mild        | High     | Weak   | Yes
    Rain    | Cool        | Normal   | Weak   | Yes
    Rain    | Cool        | Normal   | Strong | No
    Overcast| Cool        | Normal   | Strong | Yes
    Sunny   | Mild        | High     | Weak   | No
    Sunny   | Cool        | Normal   | Weak   | Yes
    Rain    | Mild        | Normal   | Weak   | Yes
    Sunny   | Mild        | Normal   | Strong | Yes
    Overcast| Mild        | High     | Strong | Yes
    Overcast| Hot         | Normal   | Weak   | Yes
    Rain    | Mild        | High     | Strong | No

    [10]
3. What is centroid based clustering? Why is k-means clustering called a centroid based clustering algorithm? Cluster the following instances of given data with the help of K means algorithm (Take K = 2, use first and last data points as initial centroids).

    Instance | X  | Y
    ---------|----|----
    P1       | 2  | 3
    P2       | 3  | 4
    P3       | 6  | 8
    P4       | 7  | 9
    P5       | 8  | 10
    P6       | 9  | 11

    [10]

**Group B (Attempt any EIGHT questions)**

4. What is a data warehouse? How is it different from a database? What is data mart? [5]
5. What is KDD? Explain with a suitable block diagram. [5]
6. What is data integration? What is data reduction? Why is data preprocessing important? [5]
7. What is Cube materialization? Define Full cube, Iceberg cube, closed cube and Shell cube. [5]
8. What is a frequent pattern? What is market basket analysis? Explain it with suitable examples. [5]
9. What is a confusion matrix? Explain the importance of confusion matrix in measuring the performance of classification models. [5]
10. What is clustering? How is it different from supervised classification? What is the DBSCAN algorithm? [5]
11. Define social network analysis. What is the motivation behind link mining? [5]

### Model Set II

**Group A (Attempt any TWO questions)**

1. Explain the different components of data warehouse. How data cube precomputation is performed? Describe. [10]
2. Write the limitation of Apriori algorithm. Given the objects P1(2,3), P2(4,5), P3(10,40), P4(60,55), P5(70,80), apply K-means algorithm (K = 2) to show the final clusters after 2 iterations. Assume P1 and P3 as initial cluster centroids. [10]
3. Consider the following training data set. (Apply ID3 or other classification approach) [10]

**Group B (Attempt any EIGHT questions)**

4. List any two challenge of multimedia mining. Differentiate between web usage mining and web content mining. [5]
5. How trust and distrust propagate in social network? Explain. [5]
6. Why data preprocessing is mandatory? Justify. [5]
7. Describe any five types of OLAP operations. [5]
8. Given the following data set, find the frequent itemset using Apriori algorithm with minimum support 3.

    TID | Items
    ----|----------------
    T1  | {A, B, C, D, E, F}
    T2  | {B, C, D, E, F, G}
    T3  | {A, D, E, H}
    T4  | {A, D, F, I, J}
    T5  | {B, D, E, K}

    [5]
9. Illustrate the hierarchical clustering with an example. [5]
10. Discuss about overfitting and underfitting. How precision and recall is used to evaluate classifier. [5]
11. What is the concept mini batch k-means? How DBSCAN works? [5]
12. How beam search and logic programming is used to mine graph? Explain. [5]

### 2082

**Section A (Attempt any TWO questions)**

1. Define strong association rule. What are the limitations of Apriori algorithm? Create a FP tree from the following data set.

    TID | List of Items
    ----|--------------
    T1  | {A, B, C}
    T2  | {B, C, D}
    T3  | {C, D}
    T4  | {B, D}
    T5  | {A, C}
    T6  | {A, C, D}

    *(2082)* [10]
2. What is the role of Laplace smoothing? Create a decision tree from the following data set using ID3 as attribute selection approach.

    Object | A1 | A2 | Class
    -------|----|----|------
    1      | T  | T  | C1
    2      | T  | T  | C1
    3      | T  | F  | C2
    4      | F  | F  | C1
    5      | F  | T  | C2
    6      | F  | T  | C2

    *(2082)* [10]
3. Consider the data set (6,3), (7,2), (4,8), (2,2), (0,2), (9,0). Taking k=3, show the result after first iteration using k-means algorithm. For choosing initial centroid, use k-means++ by taking (6,3) as initial cluster center. *(2082)* [10]

**Section B (Attempt any EIGHT questions)**

4. Explain about data mining primitives. *(2082)* [5]
5. Define support vector. Write the algorithm for back propagation for classification. *(2082)* [5]
6. What is data mart? Why do we need multidimensional data model? *(2082)* [5]
7. Describe the different types of data object and attribute types. *(2082)* [5]
8. What is data cube? List the different variations of cube materializations. *(2082)* [5]
9. What is the concept behind beam search? Discuss about theory of balance and status. *(2082)* [5]
10. Explain about web content, web usage and web structure mining. *(2082)* [5]
11. Given the following distance matrix, find the core points and outliers using DBSCAN. Take Eps = 2.5 and MinPts = 3.

    | Data Points | A    | B    | C    | D    | E    | F    | G    | H    |
    |-------------|------|------|------|------|------|------|------|------|
    | A           | 0    | 1.41 | 2.83 | 4.24 | 5.66 | 5.83 | 6.40 | 5.83 |
    | B           | 0    | 1.41 | 2.82 | 4.24 | 4.47 | 5.00 | 4.47 |
    | C           | 0    | 1.41 | 2.82 | 3.16 | 3.60 | 3.16 |
    | D           | 0    | 1.41 | 2.00 | 2.24 | 2.00 |
    | E           | 0    | 1.41 | 1.00 | 1.41 |
    | F           | 0    | 1.00 | 2.82 |
    | G           | 0    | 2.24 |
    | H           | 0    |

    *(2082)* [5]
12. List the components of data warehouse. Discuss about the trust propagation on social network. *(2082)* [5]

### 2081

**Section A (Attempt any TWO questions)**

1. When do we prefer trim mean for statistical description of data? Justify with an example. Describe about multi-dimensional data model and conceptual modeling of data warehouse. *(2081)* [10]
2. How do you generate strong association rules? From the following dataset find the frequent item set using FP growth algorithm using 3 as minimum support.

    Transaction ID | Items
    ---------------|-----------
    T1             | {K, E, M, O, Y}
    T2             | {K, E, O, Y}
    T3             | {K, E, M}
    T4             | {K, M, Y}
    T5             | {K, E, O}

    *(2081)* [10]
3. Define overfitting and under fitting. Train the decision tree classifier using the ID3 algorithm based on the following training data.

    TID | Age  | Car Type | Class
    ----|------|----------|------
    1   | ≤30  | Family   | High
    2   | ≤30  | Sports   | High
    3   | >30  | Sports   | High
    4   | >30  | Family   | Low
    5   | >30  | Truck    | Low
    6   | ≤30  | Family   | High

    *(2081)* [10]

**Section B (Attempt any EIGHT questions)**

4. Describe any two methods of handling noisy data. *(2081)* [5]
5. Using k-means++ algorithm and Euclidean distance, find the initial 3 cluster centroids from A1 = (3, 11), A2 = (3, 6), A3 = (9, 5), A4 = (6, 9), A6 = (7, 5), A7 = (2, 3), A8 = (5, 10). Choose (3, 11) as one of the initial centroids. *(2081)* [5]
6. Explain the general strategies for cube computation. *(2081)* [5]
7. Distinguish between data characterization and data discrimination. What are the challenges of multimedia mining? *(2081)* [5]
8. Define graph mining. Discuss the conflict between theory of balance and theory of status. *(2081)* [5]
9. What is support vector? How do you evaluate the accuracy of a classifier? Describe. *(2081)* [5]
10. Differentiate between k-means and k-medoids clustering algorithm. *(2081)* [5]
11. List any two OLAP operations with example. How do you compute rule coverage and rule accuracy? *(2081)* [5]
12. Define link mining. What are the roles of epsilon and MinPts in DBSCAN? *(2081)* [5]

### 2080

**SECTION A (Attempt any TWO questions)**

1. State Apriori property. Find frequent item sets and association rules from the transaction database given below using Apriori algorithm. Assume min. support is 50% and min confidence is 75%.

    Transaction ID | Items Purchased
    ---------------|----------------
    1              | Bread, Cheese, Egg, Juice
    2              | Bread, Cheese, Juice
    3              | Bread, Milk, Yogurt
    4              | Bread, Juice, Milk
    5              | Cheese, Juice, Milk

    *(2080)* [10]
2. How classification differs from regression. Train ID3 classifier using the dataset given below. Then predict class label for the data [Age=Mid, Competition=Yes, Type=HW]. *(2080)* [10]
3. Why the concept of data mart is important? Discuss different data warehouse schema with examples. *(2080)* [10]

**SECTION B (Attempt any EIGHT questions)**

4. How KDD differs from data mining? Explain various stages of KDD with suitable block diagram. *(2080)* [5]
5. Discuss different ways of smoothing noisy data along with suitable examples. *(2080)* [5]
6. How many cuboids are possible from 5-dimensional data? Discuss the concept of full cube and iceberg cube. *(2080)* [5]
7. How K-medoids clustering differs from K-means clustering? Divide the following data points into two clusters using k-medoids algorithm. Show computation up to 3 iterations. *(2080)* [5]
8. Discuss working of DBSCAN algorithm. *(2080)* [5]
9. Which algorithm is used for training multi-layer perceptron? Discuss the algorithm in detail. *(2080)* [5]
10. Explain the OLAP operations with examples. *(2080)* [5]
11. Discuss the concept of multimedia data mining along with the concept of similarity search. *(2080)* [5]
12. Write down short notes on:
    a. Support Vector Machine
    b. Multi-dimensional Data Model *(2080)* [5]

### 2079

**Section A (Attempt any two questions)**

1. Discuss any two drawbacks of Apriori algorithm. Find frequent item-sets and association rules from the transaction database given below using FP-growth algorithm. Assume minimum support is 50% and minimum confidence is 60%.

    Transaction ID | Items purchased
    ---------------|----------------
    1              | Sausage, peanut, Beer
    2              | peanut, Beer, Apple
    3              | Apple, Milk
    4              | Sausage, peanut, Apple
    5              | Sausage, peanut, Beer, Milk
    6              | Sausage, peanut, Beer, Apple

    *(2079)* [10]
2. When multilayer perceptron is better choice over other classification algorithms? Consider a multilayer feed-forward neural network given below. Let the learning rate be 0.5. Assume initial values of weights and biases as given in the table below. Train the network for the training tuples (1, 1, 0) and (0, 1, 1). Show weight and bias updates by using back-propagation algorithm.

    w13 | w14 | w23 | w24 | w35 | w45 | b3  | b4  | b5
    ----|-----|-----|-----|-----|-----|-----|-----|-----
    0.5 | 0.2 | -0.3 | 0.5  | 0.1 | 0.3 | 0.6 | -0.4 | 0.8

    *(2079)* [10]
3. Why OLAP operations are used? Discuss various OLAP operation with suitable example of each. *(2079)* [10]

**Section B (Attempt any eight questions)**

4. Suppose that we have 5 dimensional data. What will be total number of cuboids generated? If we consider each dimension has 5 levels, what will be the number of cuboids generated? *(2079)* [5]
5. Discuss different types of attributes with suitable example of each. *(2079)* [5]
6. Why data normalization is important in data mining? Explain min-max and Z-score normalization approach. *(2079)* [5]
7. What are two categories of hierarchical clustering? Divide the following data points into two clusters using agglomerative clustering. {(2,10), (2,5), (8,4), (5,8), (7,5), (6,4)}. *(2079)* [5]
8. Discuss the concept of K-means++ and Mini-batch K-means algorithm. *(2079)* [5]
9. What is confusion matrix? Discuss various classification measures along with their mathematical formulae. *(2079)* [5]
10. What are application areas of graph mining? Explain the concept behind inductive logic programming with suitable demonstration. *(2079)* [5]
11. Discuss the concept of text mining with its practical implications. *(2079)* [5]
12. Write down short notes on:
    a. Data Mart
    b. Market Basket Analysis *(2079)* [5]

### 2078

**Section A (Attempt any two questions)**

1. Write down any one advantage and disadvantage of MOLAP over ROLAP. Define signed network and how do you check whether it is balanced or not? How beam search reduces the space complexity? Illustrate with an example. *(2078)* [10]
2. How concept hierarchy is used in extracting information? Generate the frequent pattern from the following data set using FP growth, where minimum support=3. *(2078)* [10]
3. How do you compare two classifiers? Given the points A(3,7), B(4,6), C(5,5), D(6,4), E(7,3), F(6,2), G(7,2) and H(8,4), find the core points, border points and outliers using DBSCAN. Take Eps 2.5 and MinPts = 3. *(2078)* [10]

**Section B (Attempt any eight questions)**

4. When a pattern is said to be interesting? List the issues of data mining. *(2078)* [5]
5. Define data discretization. Describe the tasks for data preprocessing. *(2078)* [5]
6. Define spatial data mining. What are the challenges of multimedia mining? Describe with an example. *(2078)* [5]
7. Consider the given data set.

    Confident | Studied | Sick | Result
    ----------|---------|------|-------
    Yes       | No      | No   | Fail
    Yes       | No      | No   | Pass
    No        | Yes     | Yes  | Fail
    No        | Yes     | Yes  | Pass
    Yes       | Yes     | Yes  | Pass

    Find out whether the object with attribute Confident = Yes, Sick = No will Fail or Pass using Bayesian classification. *(2078)* [5]
8. What are the choices for data cube materialization? Explain the strategies for cube computation. *(2078)* [5]
9. Show the conflict between theory of balance and status. How do you improve Apriori? *(2078)* [5]
10. Differentiate between star schema and snow flake schema. List any two methods for data normalization. *(2078)* [5]
11. How do you evaluate the accuracy of a classifier? Discuss the advantages of using K-fold cross validation. *(2078)* [5]
12. Apply K(=2)-Means algorithm over the data (185, 72), (170, 56), (168, 60), (179, 68), (182, 72), (188, 77) up to two iterations and show the clusters. Initially choose first two objects as initial centroids. *(2078)* [5]

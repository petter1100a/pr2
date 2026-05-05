# Practical 4: Fuzzy Set Operations

## Theory
**Fuzzy Sets** are sets whose elements have degrees of membership between 0 and 1, unlike classical sets where membership is binary (0 or 1).

### Key Operations:
1. **Union (A ∪ B):** Uses the `MAX` operator. $\mu(x) = \max(\mu_A(x), \mu_B(x))$
2. **Intersection (A ∩ B):** Uses the `MIN` operator. $\mu(x) = \min(\mu_A(x), \mu_B(x))$
3. **Complement (A'):** Calculated as $1 - \mu_A(x)$.
4. **Max-Min Composition:** Used in fuzzy relations to combine two relations into one.

## How to Run
Open the `.ipynb` file in Jupyter Notebook or Google Colab and run the cells.

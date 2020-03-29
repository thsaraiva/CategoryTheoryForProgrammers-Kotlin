/**
 * 1. Generate a free category from:
 *  (a) A graph with one node and no edges
 *  (b) A graph with one node and one (directed) edge(called f) (hint: this edge can be composed with itself)
 *  (c) A graph with two nodes and a single arrow between them
 *  (d) A graph with a single node and 26 arrows marked with the letters of the alphabet: a, b, c ... z.
 */
//Method:
//First, add an identity arrow at each node.
//Then, for any two composable arrows, add a new arrow to serve as their composition.
//Every time you add a new arrow, you have to also consider its composition with any other arrow (except for the identity arrows) and itself.

// a) Add identity
// b) Add the identity, and infinite arrows representing f.f, f.f.f, f.f.f.f ...etc
// c) Add 2 identities
// d) Add identity and another arrow for each composition : a.b, a.b.c, a.b.a, b.a. ... infinite arrows.

/**
 * 2. What kind of order is this?
 * (a) A set of sets with the inclusion relation: 𝐴 is included in 𝐵 if every element of 𝐴 is also an element of 𝐵.
 * (b) C++ types with the following subtyping relation: T1 is a sub-type of T2 if a pointer to T1 can be passed to a
 * function that expects a pointer to T2 without triggering a compilation error.
 */

// a)Partial order
// b)Partial order

/**
 * 3. Considering that Bool is a set of two values True and False,show that it forms two (set-theoretical) monoids
 * with respect to, respectively, operator && (AND) and || (OR).
 **/
// AND
// (A && B) && C == A && (B || C)
// Associative is easy to prove. If at least one if False, result is False  on both sides. If all are True, result is True on both sides.
// Identity: True

// OR
// (A || B) || C == A || (B || C)
// Associative is easy to prove. If at least one if True, result is True on both sides. If all are False, result is False on both sides.
// Identity: False


/**
 * 4. Represent the Bool monoid with the AND operator as a category: List the morphisms and their rules of composition.
 **/
//It's a category with one Object, the Bool type, and the following morphisms:

// f,g, :: Bool -> Bool (They all compose as they all start and end in Bool)
// f x = x && True (identity)
// g x = x && False
// f.g x = x && True && False = False


/**
 * 5. Represent addition modulo 3 as a monoid category.
 **/
//Single object category (C) where the Object is the Type Natural non-negative numbers.
//Hom-set of C is:
// f x = (x + 0) % 3 = x % 3 -> Identity
// g x = (x + 1) % 3
// h x = (x + 2) % 3

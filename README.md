# Paths-in-Maze-
You are given a maze that is represented by a matrix. In this matrix, 0 is a road element that can pass and 1 is a wall element that can't pass.

Please find a valid path, which is composed of successive coordinates for road elements, from a start coordinate to an end coordinate in the maze. Jumping over a wall element or from a coordinate to another non-adjacent coordinate is not allowed.

You should return a list of directions (UP, DOWN, LEFT, and RIGHT) indicating how to construct the path from the start coordinate.

For example, suppose we have the maze below, a valid path from the start coordinate (0, 1) to the end coordinate (3, 4) should be [DOWN, RIGHT, RIGHT, DOWN, DOWN, RIGHT].

{1, 0, 1, 0, 1}
{1, 0, 0, 0, 1}
{1, 0, 1, 0, 1}
{1, 0, 1, 0, 0}

The elements of the start coordinate and the end coordinate are both road elements.

If the path doesn't exist, please return null.

If there exist multiple paths, the method can return an arbitary one of them.

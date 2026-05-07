This collage uses a LeBron James photo (bron.jpg) as the base image, and goat.jpg
used in the blend. The 9 pictures on the canvas are in a 3x3 grid:

Top row:
1. Mirror Vertical - copies the left half of the picture onto the right half,
   mirrored around the vertical center line.
2. Blend - overwrites every other column of the LeBron picture with pixels from
   the goat picture, blending the two together.
3. Shephard Fairey - takes the average RGB value of each pixel and replaces it
   with one of seven ROYGBV+pink colors based on which range it falls into.

Middle row:
4. Recursive - shrinks the picture in half by sampling every other pixel, then
   pastes the small copy into the top-left corner. The function calls itself on
   the small copy.
5. Rotate 180 - swaps each pixel with the pixel at the opposite
   corner, flipping the picture upside-down.
6. Blue Tint - cuts the red and green values in half and increases the blue
   value by 1.5x, giving the picture a blue color tint.

Bottom row:
7. Edge Detection - compares each pixel's brightness to the pixel below it.
   If the difference is small, the pixel is painted white. If the difference
   is large (an edge), the pixel is painted black.
8. Pixelate - breaks the picture into 20x20 squares and fills each square
   with the color of its top-left pixel.
9. Negate - flips every color channel to its opposite (255 - value)

Required transformations:
- Mirror: pic 1 (vertical mirror)
- Original manipulation: pic 3 (Shephard Fairey rainbow filter)
- Recursive manipulation: pic 4 
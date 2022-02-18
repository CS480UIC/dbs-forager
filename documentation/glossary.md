
## Entity Name : food
Synonyms : Meal, Grub <br />
Description : Food is requested by a user who is a receiver and is donated by a donor.

## Relationship

1. [Food-Contains-Nutrition](#Food-Contains-Nutrition) - <br />
- Relationship Maxima : (M-1) <br />
- Relationship Minima : (1-1) <br />
2. [Order-Contains-Food](#[Order-Contains-Food) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (0-1) <br />
3. [Donor-Donates-Food](#Donor-Donates-Food) - <br />
- Relationship Maxima : (M-1) <br />
- Relationship Minima : (1-1) <br />

## Attributes
1. food_id
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) <br />
2. food_type
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
3. calorie_tracker
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (0) <br />
4. donor_id
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />

## Entity Name : order
Synonyms : Order, Booking <br />
Description : An Order is delivered to the receiver by a volunteer and the order placed by the receiver is fulfilled by a donor.

## Relationship

1. [Receiver-Receives-Order](#Food-Contains-Nutrition) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1-1) <br />
2. [Donor-Donates-Order](#[Order-Contains-Food) - <br />
- Relationship Maxima : (M-M) <br />
- Relationship Minima : (1-0) <br />
3. [Order-Contains-Food](#[Order-Contains-Food) - <br />
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (0-1) <br />

## Attributes
1. order_id
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) <br />
2. pick_up_location
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
3. drop_location
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
4. transporter_id
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
5. food_id
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
6. pick_up_time
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) <br />
7. drop_time
- Relationship Maxima : (1-1) <br />
- Relationship Minima : (1) <br />
8. receiver_id
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />
9. donor_id
- Relationship Maxima : (1-M) <br />
- Relationship Minima : (1) <br />


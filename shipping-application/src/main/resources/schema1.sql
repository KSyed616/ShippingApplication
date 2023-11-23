Alter table shipments
Drop column delivery_date,
Drop column delivery_location,
Drop column pickup_date,
Drop column pickup_location,
Drop column shipping_method,
Drop column shipment_id;

Insert into shipments(CustomerID, DeliveryLocation, PickupDate, ShippingMethod, Status)
Values (1, '285 Victoria St, Toronto, ON M5B 1W1', 'Wednesday, November 22, 2023', 'Express', 'Pending');
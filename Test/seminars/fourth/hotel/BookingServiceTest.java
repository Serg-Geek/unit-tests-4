package seminars.fourth.hotel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class BookingServiceTest {


        @Test
    void testBookingService() {

            HotelService hotelServiceMock = mock(HotelService.class);
            when(hotelServiceMock.isRoomAvailable(anyInt()))
                    .thenReturn((anyInt() % 2==0));


            BookingService bookingService = new BookingService(hotelServiceMock);
            assertTrue(bookingService.bookRoom(2));
            verify(hotelServiceMock, times(1));
        }


    @Test
    void testBookingServiceFalse() {

            HotelService hotelServiceMock = mock(HotelService.class);
            when(hotelServiceMock.isRoomAvailable(anyInt()))
                    .thenReturn((anyInt() % 2  != 0));


            BookingService bookingService = new BookingService(hotelServiceMock);

            assertFalse(bookingService.bookRoom(3));
            verify(hotelServiceMock, times(1));
        }
}
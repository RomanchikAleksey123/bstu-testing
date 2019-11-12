using System;

namespace Aircompany.Planes
{
    public class PassengerPlane : Plane
    {
        private int _passengersCapacity;

        public PassengerPlane(string model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity)
            :base(model, maxSpeed, maxFlightDistance, maxLoadCapacity)
        {
            _passengersCapacity = passengersCapacity;
        }

        public override bool Equals(object obj)
        {
            var plane = obj as PassengerPlane;
            return plane != null &&
                   base.Equals(obj) &&
                   _passengersCapacity == plane._passengersCapacity;
        }

        public override int GetHashCode()
        {
            return (base.GetHashCode() + _passengersCapacity).GetHashCode();
        }

        public int GetPassengersCapacity()
        {
            return _passengersCapacity;
        }
       
        public override string ToString()
        {
            return string.Format("{0}, PassangerCapacity: {1}", base.ToString(), _passengersCapacity);
        }          
    }
}

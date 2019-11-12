using Aircompany.Models;

namespace Aircompany.Planes
{
    public class MilitaryPlane : Plane
    {
        private MilitaryType _militaryType;

        public MilitaryPlane(string model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type)
            : base(model, maxSpeed, maxFlightDistance, maxLoadCapacity)
        {
            _militaryType = type;
        }

        public override bool Equals(object obj)
        {
            MilitaryPlane plane = obj as MilitaryPlane;
            return plane != null &&
                   base.Equals(obj) &&
                   _militaryType == plane._militaryType;
        }

        public override int GetHashCode()
        {
            return (base.GetHashCode() + _militaryType.GetHashCode()).GetHashCode();
        }

        public MilitaryType GetMilitaryType()
        {
            return _militaryType;
        }


        public override string ToString()
        {
            return string.Format("{0}, MilitaryType:{1}", base.ToString(), _militaryType);
        }        
    }
}

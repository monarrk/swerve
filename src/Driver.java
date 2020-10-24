// MIT License
//
// Copyright (c) 2020 Skye Bleed
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

public class Driver {
	public static void main(String[] args) {
		Wheels wheels = new Wheels(
			new Vector(-1, 1),
			new Vector(1, 1),
			new Vector(-1, -1),
			new Vector(1, -1));

		System.out.println(wheels.dump());
	}
}

/// All 4 wheels
class Wheels {
	/// The front left wheel
	Wheel front_left;
	/// The front right wheel
	Wheel front_right;
	/// The back left wheel
	Wheel back_left;
	/// The back right wheel
	Wheel back_right;

	public Wheels(Vector fl, Vector fr, Vector bl, Vector br) {
		this.front_left = new Wheel(fl);
		this.front_right = new Wheel(fr);
		this.back_left = new Wheel(bl);
		this.back_right = new Wheel(br);
	}

	/// Dump the contents of the wheels and their vectors into a String
	public String dump() {
		return "front_left:\n"
			+ String.format("\tpos:\n\t\t%s\n", front_left.pos.toString())
			+ "front_right:\n"
			+ String.format("\tpos:\n\t\t%s\n", front_right.pos.toString())
			+ "back_left:\n"
			+ String.format("\tpos:\n\t\t%s\n", back_left.pos.toString())
			+ "back_right:\n"
			+ String.format("\tpos:\n\t\t%s\n", back_right.pos.toString());
	}
}

/// One wheel
class Wheel {
	/// The current vector's position
	public Vector pos;

	public Wheel(Vector v) {
		this.pos = v;
	}
}

/// A vector to do fancy positional mathematics with
class Vector {
	/// The X component
	private final double x;
	/// The Y component
	private final double y;
	/// The resultant
	private final double res;
	/// The angle (degrees)
	private final double angle_deg;
	/// The angle (radians)
	private final double angle_rad;

	/// Default constructor, finds resultant and angle from components
	Vector(double x, double y) {
		this.x = x;
		this.y = y;

		this.res = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

		// TODO(@monarrk): verify this works with actual math
		this.angle_rad = Math.atan(y / x);
		this.angle_deg = Math.toDegrees(this.angle_rad);
	}

	// TODO: impl
	/// Find from an x component and angle
	//static Vector from_x(double x, double angle) {
	//
	//}

	/// Get the X value
	double get_x() { return this.x; }
	/// Get the Y value
	double get_y() { return this.y; }
	/// Get the resultant
	double get_res() { return this.res; }
	/// Get the angle in degrees
	double get_angle_deg() { return this.angle_deg; }
	/// Get the angle in radians
	double get_angle_rad() { return this.angle_rad; }

	/// Return a Pair<> type to return both x and y at once
	Pair<Integer, Integer> get() { return new Pair(this.x, this.y); }

	/// display a Vector as a String
	public String toString() {
		return String.format("x: %f, y: %f, resultant: %f, angle (deg): %f, angle (rad): %f",
			this.x,
			this.y,
			this.res,
			this.angle_deg,
			this.angle_rad);
	}
}

/// A Pair type to emulate tuples/multiple return vals
class Pair<T, E> {
	/// The first item in the pair
	T x;
	/// The second item in the pair
	E y;

	Pair(T x, E y) {
		this.x = x;
		this.y = y;
	}
}

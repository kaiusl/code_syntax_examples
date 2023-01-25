//! module level doc comment
#![allow(unused_imports)]
#![allow(dead_code)]
#![allow(unused_variables)]
#![allow(clippy::overly_complex_bool_expr)]

use ::std::io::Write;
use std::file;
use std::fmt::Display;
use std::rc::{self as std_rc, Rc};
use std::sync::atomic::*;

mod other_mod;
use self::other_mod::CONSTANT3;
use crate::other_mod::CONSTANT2;
pub use other_mod::CONSTANT as OTHER_CONSTANT;

extern crate rstest;
extern "C" {}
extern "C" fn c_func() {}

// comment
/* comment */

const CONSTANT: u32 = 5;
static STATIC: u32 = 5;

const fn const_func() -> Result<(), std::io::Error> {
    Ok(())
}

fn impl_return() -> impl Iterator<Item = usize> {
    vec![0].into_iter()
}

/// doc comment
pub(crate) async unsafe fn func<'lifetime, 'other, T: ?Sized, const CONST_GENERIC: usize>(
    mut param: T,
    ref_param: &'lifetime mut str,
    impl_param: impl AsRef<str>,
    dyn_param: &'other dyn AsRef<str>,
    func_param: fn(usize) -> String,
    Struct { field, field2 }: Struct,
) -> Result<&'other str, std::io::Error>
where
    T: Iterator + Display + Copy + 'lifetime,
    <T as Iterator>::Item: Default + for<'a> From<&'a str>,
    'lifetime: 'other,
{
    const_func()?;
    let use_const = CONSTANT + STATIC;
    const LOCAL_CONSTANT: u32 = 5;
    static LOCAL_STATIC: u32 = 5;

    // References and pointers
    let _ref = &param;
    let deref = *_ref;
    let ref _ref = param;
    let _ref_dyn = _ref as &dyn Display;
    let _ref_mut = &mut param;
    let ref mut _ref_mut = param;
    let pointer = &param as *const T;
    let pointer: *const T = &param;
    let pointer_mut = &mut param as *mut T;
    let pointer_mut: *mut T = &mut param;
    let deref_pointer = unsafe { *pointer_mut };

    // Variables and their creation
    let nums = (
        1, 1u32, 1_u32, 1_000, 1.0, 1.0f32, 1.0e5, 1.0e+5, 1.0E-5, 0b1000, 0o1234, 0x1234,
    );
    let strings = (
        "string with escapes \n \u{1234}",
        b"byte string",
        r"raw string",
        br"raw byte string",
        r#"raw string with "quotes" "#,
    );
    let (chara, newline) = ('a', '\n');
    let bools = [true, false, true, false, true];
    let bools_slice = &bools[..];
    let bools_slice = &bools[1..=3];
    let mut vec = Vec::<String>::new();
    let value = "value";
    vec.push(value.into());
    let vec = vec.iter().collect::<Vec<_>>();

    let closure = move |a: usize, b: EnumTypeAlias| bools[a];
    let _enum = EnumTypeAlias::Plain;
    let _enum2: Enum<Vec<i32>> = Enum::TupleLike(vec![]);
    let _enum3 = Enum::new_tuple(5);
    let _struct2 = Struct {
        field: 1,
        field2: 2,
    };
    let Struct { field, field2 } = Struct {
        field: 1,
        ..Default::default()
    };

    // Loops
    let returned_from_loop = 'label: loop {
        for item in &vec {
            if item.starts_with('a') {
                break 'label item;
            }
            continue;
        }
    };

    while let Some(a) = param.next() {}

    // Conditionals
    if nums.1 < 5 {}

    let err = std::io::Error::new(std::io::ErrorKind::Other, "");
    if let Enum::TupleLike(items) = _enum2 {}
    let Some(a) = Some(5) else { return Err(err) };

    match (1, 2, 3) {
        (a, ..) | (_, a, ..) if a == 2 => {}
        all @ (_, b, ..) if b == 0 || all.2 == 0 => {}
        _ => {
            panic!("unrecoverable error")
        }
    }

    match [1, 2, 3].as_slice() {
        [] => {}
        [first] => {}
        [_, second, mid @ .., last] => {}
        [..] => {}
    }

    match _enum3 {
        Enum::Plain => todo!(),
        Enum::TupleLike(field) => todo!(),
        Enum::StructLike { field } => {}
    }

    Ok(ref_param)
}

#[cfg(target_os = "linux")]
#[derive(Debug, Default)]
struct OnlyLinuxStruct {
    field: usize,
    field2: usize,
}

#[derive(Debug, Default)]
struct Struct {
    field: usize,
    field2: usize,
}

#[derive(Debug, Clone)]
pub enum Enum<T = u32> {
    Plain,
    TupleLike(T),
    StructLike { field: [T; 3] },
}

pub union Union {
    field: usize,
    field2: f64,
}

type EnumTypeAlias = Enum<u32>;

impl<T> Enum<T> {
    #[must_use]
    pub fn new_plain() -> Self {
        Self::Plain
    }

    pub fn new_tuple(val: T) -> Self {
        Self::TupleLike(val)
    }

    pub fn new_struct(val: T) -> Self
    where
        T: Copy,
    {
        Self::StructLike { field: [val; 3] }
    }

    pub fn takes_owned(self) {}
    pub fn takes_ref(&self) {}
    pub fn takes_mut_ref(&mut self) {}
    pub fn takes_rc_self(self: Rc<Self>) {}
}

pub(crate) trait Trait<'a>: std::fmt::Debug {
    type AssociatedType<'inner, T>
    where
        Self: 'inner,
        T: 'inner;

    fn func(&self) -> Option<usize> {
        None
    }
}

impl<'a> Trait<'a> for Struct {
    type AssociatedType<'inner, T> = &'inner T where T: 'inner;

    fn func(&self) -> Option<usize> {
        Some(5)
    }
}

impl Display for Struct {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        todo!()
    }
}

macro_rules! some_macro {
    ($($t:ty),* => $name:ident) => {
       $(
            pub fn $name(var: $t) -> Result<u64, String> {
                Ok(var.into())
            }
       )*
    };
}

some_macro!(u32 => func_u32);

pub fn add(left: usize, right: usize) -> usize {
    left + right
}

#[cfg(test)]
mod tests {
    use rstest::rstest;

    use super::*;

    #[test]
    fn it_works() {
        let result = add(2, 2);
        assert_eq!(result, 4);
    }

    #[rstest]
    #[case::name("fsa")]
    fn case_test(#[case] a: &str) {}
}

/// All the code from above but in a doc example.
///
/// ```
/// //! module level doc comment
/// #![allow(unused_imports)]
/// #![allow(dead_code)]
/// #![allow(unused_variables)]
/// #![allow(clippy::overly_complex_bool_expr)]
///
/// use ::std::io::Write;
/// use std::file;
/// use std::fmt::Display;
/// use std::rc::{self as std_rc, Rc};
/// use std::sync::atomic::*;
///
/// // mod other_mod;
/// use self::other_mod::CONSTANT3;
/// use crate::other_mod::CONSTANT2;
/// pub use other_mod::CONSTANT as OTHER_CONSTANT;
///
/// extern crate rstest;
/// extern "C" {}
/// extern "C" fn c_func() {}
///
/// // comment
/// /* comment */
///
/// const CONSTANT: u32 = 5;
/// static STATIC: u32 = 5;
///
/// const fn const_func() -> Result<(), std::io::Error> {
///     Ok(())
/// }
///
/// fn impl_return() -> impl Iterator<Item = usize> {
///     vec![0].into_iter()
/// }
///
/// /// doc comment
/// pub(crate) async unsafe fn func<'lifetime, 'other, T: ?Sized, const CONST_GENERIC: usize>(
///     mut param: T,
///     ref_param: &'lifetime mut str,
///     impl_param: impl AsRef<str>,
///     dyn_param: &'other dyn AsRef<str>,
///     func_param: fn(usize) -> String,
///     Struct { field, field2 }: Struct,
/// ) -> Result<&'other str, std::io::Error>
/// where
///     T: Iterator + Display + Copy + 'lifetime,
///     <T as Iterator>::Item: Default + for<'a> From<&'a str>,
///     'lifetime: 'other,
/// {
///     const_func()?;
///     let use_const = CONSTANT + STATIC;
///
///     let _ref = &param;
///     let deref = *_ref;
///     let ref _ref = param;
///     let _ref_dyn = _ref as &dyn Display;
///     let _ref_mut = &mut param;
///     let ref mut _ref_mut = param;
///     let pointer = &param as *const T;
///     let pointer: *const T = &param;
///     let pointer_mut = &mut param as *mut T;
///     let pointer_mut: *mut T = &mut param;
///     let deref_pointer = unsafe { *pointer_mut };
///
///     // Variables and their creation
///     let nums = (
///         1, 1u32, 1_u32, 1_000, 1.0, 1.0f32, 1.0e5, 1.0e+5, 1.0E-5, 0b1000, 0o1234, 0x1234,
///     );
///     let strings = (
///         "string with escapes \n \u{1234}",
///         b"byte string",
///         r"raw string",
///         br"raw byte string",
///         r#"raw string with "quotes" "#,
///     );
///     let (chara, newline) = ('a', '\n');
///     let bools = [true, false, true, false, true];
///     let bools_slice = &bools[..];
///     let bools_slice = &bools[1..=3];
///     let mut vec = Vec::<String>::new();
///     let value = "value";
///     vec.push(value.into());
///     let vec = vec.iter().collect::<Vec<_>>();
///
///     let closure = move |a: usize, b: EnumTypeAlias| bools[a];
///     let _enum = EnumTypeAlias::Plain;
///     let _enum2: Enum<Vec<i32>> = Enum::TupleLike(vec![]);
///     let _enum3 = Enum::new_tuple(5);
///     let _struct2 = Struct {
///         field: 1,
///         field2: 2,
///     };
///     let Struct { field, field2 } = Struct {
///         field: 1,
///         ..Default::default()
///     };
///
///     // Loops
///     let returned_from_loop = 'label: loop {
///         for item in &vec {
///             if item.starts_with('a') {
///                 break 'label item;
///             }
///             continue;
///         }
///     };
///
///     while let Some(a) = param.next() {}
///
///     // Conditionals
///     if nums.0 < 5 {}
///
///     let err = std::io::Error::new(std::io::ErrorKind::Other, "");
///     if let Enum::TupleLike(items) = _enum2 {}
///     let Some(a) = Some(5) else { return Err(err); };
///
///     match (1, 2, 3) {
///         (a, ..) | (_, a, ..) if a == 2 => {}
///         all @ (_, b, ..) if b == 0 || all.2 == 0 => {}
///         _ => {
///             panic!("unrecoverable error")
///         }
///     }
///
///     match [1, 2, 3].as_slice() {
///         [] => {}
///         [first] => {}
///         [_, second, mid @ .., last] => {}
///         [..] => {}
///     }
///
///     match _enum3 {
///         Enum::Plain => todo!(),
///         Enum::TupleLike(field) => todo!(),
///         Enum::StructLike { field } => todo!(),
///     }
///
///     Ok(ref_param)
/// }
///
/// #[cfg(target_os = "linux")]
/// #[derive(Debug, Default)]
/// struct Struct {
///     field: usize,
///     field2: usize,
/// }
///
/// #[derive(Debug, Clone)]
/// pub enum Enum<T = u32> {
///     Plain,
///     TupleLike(T),
///     StructLike { field: [T; 3] },
/// }
///
/// pub union Union {
///     field: usize,
///     field2: f64,
/// }
///
/// type EnumTypeAlias = Enum<u32>;
///
/// impl<T> Enum<T> {
///     #[must_use]
///     pub fn new_plain() -> Self {
///         Self::Plain
///     }
///
///     pub fn new_tuple(val: T) -> Self {
///         Self::TupleLike(val)
///     }
///
///     pub fn new_struct(val: T) -> Self
///     where
///         T: Copy,
///     {
///         Self::StructLike { field: [val; 3] }
///     }
///
///     pub fn takes_owned(self) {}
///     pub fn takes_ref(&self) {}
///     pub fn takes_mut_ref(&mut self) {}
///     pub fn takes_rc_self(self: Rc<Self>) {}
/// }
///
/// pub(crate) trait Trait<'a>: std::fmt::Debug {
///     type AssociatedType<'inner, T>
///     where
///         Self: 'inner,
///         T: 'inner;
///
///     fn func(&self) -> Option<usize> {
///         None
///     }
/// }
///
/// impl<'a> Trait<'a> for Struct {
///     type AssociatedType<'inner, T> = &'inner T where T: 'inner;
///
///     fn func(&self) -> Option<usize> {
///         Some(5)
///     }
/// }
///
/// impl Display for Struct {
///     fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
///         todo!()
///     }
/// }
///
/// macro_rules! some_macro {
///     ($($t:ty),* => $name:ident) => {
///        $(
///             pub fn $name(var: $t) -> Result<u64, String> {
///                 Ok(var.into())
///             }
///        )*
///     };
/// }
///
/// some_macro!(u32 => func_u32);
///
/// pub fn add(left: usize, right: usize) -> usize {
///     left + right
/// }
///
/// #[cfg(test)]
/// mod tests {
///     use rstest::rstest;
///
///     use super::*;
///
///     #[test]
///     fn it_works() {
///         let result = add(2, 2);
///         assert_eq!(result, 4);
///     }
///
///     #[rstest]
///     #[case::name("fsa")]
///     fn case_test(#[case] a: &str) {}
/// }
/// ```
struct DocTest;
